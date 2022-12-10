package chap6.boot.ex2;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ex2")
public class LoginController {
	@Autowired
	MemberDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginReq(Model model) {
		return "loginForm";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcessing(HttpServletRequest req, Model model, HttpSession session) {
		try {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HashMap<String, Boolean> errors = new HashMap<>();
		MemberVO login = dao.getMemberByEmail(email);

		if (login.email == null || email.isEmpty())
			errors.put("notfound", true);
		if (login.password == null || password.isEmpty())
			errors.put("mismatch", true);
		if (!errors.isEmpty()) {
			model.addAttribute("errors", errors);
			return "errorPage";
		}
		
		if (email.equals(login.email) && password.equals(login.password)) {
			session = req.getSession();
			session.setAttribute("login", login);
		}

		return "redirect:/ex2/list";
	}
	catch(Exception e) {
		model.addAttribute("exception",true);
		return "errorPage";
	}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/ex2/list";

	}

}
