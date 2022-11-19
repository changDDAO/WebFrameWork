package ch05.ex04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex04")
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/list") 
	public String memberlistPage(Model model){
		model.addAttribute("members", dao.listMembers());
		return "ex04/listMembers";
	}
	
	@RequestMapping("/addForm")
	public String addForm() {
		return "ex04/addForm";
	}
	
	@RequestMapping("/add")
	public String addNewMember(Model model, MemberVO member) {
		System.out.println(member);
		dao.addMember(member);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String deleteMember(Model model, HttpServletRequest request) {
		dao.deleteMember(request.getParameter("id"));
		return "redirect:list";
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@RequestMapping("/test")
	public String transactionTest(HttpServletRequest request) {
		dao.deleteMember("5");
		MemberVO member = new MemberVO();
		member.setEmail("email");
		member.setName("name");
		member.setPassword("password");
		member.setRegdate("잘못된 날짜 format");
		dao.addMember(member);
		return "redirect:list";
	}
}
