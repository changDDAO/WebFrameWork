package chap5.ex2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value="/", produces="text/plain;charset=UTF-8")
	public @ResponseBody String root() {
		return "Form 데이터 전달받아 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id, @RequestParam("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test2";
	}
	
	@RequestMapping("/test3")
//	public String test3(Member member, Model model) {
	public String test3(Member memberObj) {
		//memberObj.setId("changhoYoun");
		//memberObj.setName("창호 윤");
		return "test3";
	}
	
	@RequestMapping("/test4/{studentId}/{name}") 
	public String getStudent(@PathVariable String studentId, @PathVariable String name, Model model) {
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		return "test4";
	}
}