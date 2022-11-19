package chap5.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex03")
public class MyUserController {
	@Autowired
	private MyUserDAO userDao;	 // DAO 객체에 대한 dependency injection
	
	@RequestMapping(value="/", produces="text/plain;charset=UTF-8")
	public @ResponseBody String root() throws Exception {
		return "JdbcTemplate 사용하기";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userlist";
	}

}
