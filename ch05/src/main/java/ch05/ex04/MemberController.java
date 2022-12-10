package ch05.ex04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/delete/{id}")
	public String deleteMember(@PathVariable String id) {
		System.out.println(id);
		dao.deleteMember(id);
		return "redirect:/ex04/list";
	}
	
	
	@RequestMapping("/update")
	public String updateData(HttpServletRequest request, MemberVO member) {
		System.out.println(member);
		dao.updateMember(member);
		return "redirect:list";
	}
	
	@RequestMapping("/list/{id}")
	public String giveDataById(@PathVariable String id, Model model) {
		MemberVO member=dao.getMember(id);
		model.addAttribute("member",member);
		return "ex04/updateForm";
	}
}
