package yu.mybatis;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yu.mybatis.repository.CommentRepository;

import yu.mybatis.model.CommentVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private CommentRepository repository;
	
	@RequestMapping("/")
	public @ResponseBody String home(Locale locale, Model model) {
		return "Welcome Mybatis Test!";
	}
	
	@RequestMapping("/select/{commentNo}")
	public String selectCommentByPrimaryKey(@PathVariable String commentNo, Model model) {
		CommentVO comment = repository.selectCommentByPrimaryKey(Integer.parseInt(commentNo));
		model.addAttribute("comment", comment);
		return "single_comment";
	}
	
	@RequestMapping("/constructor/{commentNo}")
	public String selectCommentConstructor(@PathVariable String commentNo, Model model) {
		CommentVO comment = repository.selectCommentByPrimaryKey(Integer.parseInt(commentNo));
		model.addAttribute("comment", comment);
		return "single_comment";
	}
	
	@RequestMapping("/select/all")
	public String selectAllComments(Model model) {
		List<CommentVO> comments = repository.selectAllComments();
		model.addAttribute("comments", comments);
		return "comment_list";
	}
	
	@Transactional
	@RequestMapping("/delete/max")
	public String deleteCommentByPrimaryKey(Model model) {
		int commentNo = repository.selectMaxCommentNo();
		repository.deleteComment(commentNo);
		return "redirect:/select/all";
	}
}
