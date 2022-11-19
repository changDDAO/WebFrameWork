package SpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringMVC.model.ArticleDAO;

@Controller
public class ArticleController {
	@Autowired
	ArticleDAO dao;
	
	@RequestMapping("ex2/list")
		public String listAllArticles(Model model) {
		List<ArticleVO> articles = dao.getAllArticles();
		model.addAttribute("articles" , articles);
		return "listArticles";
	}
}
