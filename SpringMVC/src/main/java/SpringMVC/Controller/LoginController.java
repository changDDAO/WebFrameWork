package SpringMVC.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ex2/login")
public class LoginController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginReq(Model model) {
		return "loginForm";
				
}
	@RequestMapping(method=RequestMethod.POST)
	public String loginProcessing(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HashMap<String, Boolean> errors = new HashMap<>();
		
		if(email == null || email.isEmpty())
			errors.put("email", true);
		if(password == null || password.isEmpty())
			errors.put("password", true);
		if(!errors.isEmpty()) {
			model.addAttribute("errors", errors);
			return "loginForm";
		}
	MemberVO member = dao.getMemberByEmail(email);
	if(member == null)

	
	
	}
		
