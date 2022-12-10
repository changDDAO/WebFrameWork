package chap6.boot.ex2;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ArticleController {
	@Autowired

	ArticleDAO dao;
	HttpSession session;

	@RequestMapping("ex2/list")
	public String listAllArticles(Model model) {
		List<ArticleVO> articles = dao.getAllArticles();
		model.addAttribute("articles", articles);
		return "listArticles";
	}

	@RequestMapping("ex2/write")
	public String writeArticle() {
		return "writeArticle";
	}
	
	@RequestMapping(value ="ex2/delete", method = RequestMethod.GET)
	public String deleteArticle(String aid, HttpServletRequest req, Model model) {
		try{ArticleVO article = dao.getArticleByNo(aid);
		MemberVO member = (MemberVO)req.getSession().getAttribute("login");
		
		if(article.writer==member.id) {
			dao.delArticle(aid);
			return "redirect:/ex2/list";
		}
		else {
			model.addAttribute("delete", true);
			return "noPermissionPage";
			}
		}catch(Exception e) {
			return "noPermissionPage";
		}
	}

	@RequestMapping(value = "ex2/getWrote", method = RequestMethod.POST)
	public String registArticle(HttpServletRequest req) {
		MemberVO loginMember = (MemberVO) req.getSession().getAttribute("login");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int writer = loginMember.getId();
		int article_num;

		if (dao.addArticle(writer, title) == 1) {
			article_num = dao.get_articleNum(loginMember.id, title); // article num
			dao.addArticleContent(article_num, content);
		}

		// 가장 이상적인게 title content table이 다르므로, ArticleDAO 에서 parameter에 title, content
		return "redirect:list";
	}	
	@RequestMapping(value ="ex2/read", method = RequestMethod.GET)
	public String readTitle(Model model,String aid) {
		ArticleVO article = dao.getArticleByNo(aid);
		String name = dao.getNameByWriter(article.writer);
		String content = dao.getContent(aid);
		dao.plusReadCnt(aid);
		System.out.println(article);
		model.addAttribute("name", name);
		model.addAttribute("content", content);
		model.addAttribute("article", article);
		return "detailContent";
	}
	
	@RequestMapping(value ="ex2/update", method =RequestMethod.GET)
	public String updateArticle(String aid, HttpServletRequest req, Model model) {
		try{ArticleVO article = dao.getArticleByNo(aid);
		MemberVO member = (MemberVO)req.getSession().getAttribute("login");
		String content = dao.getContent(aid);
		if(article.writer==member.id) {
			model.addAttribute("content", content);
			model.addAttribute("article", article);
			return "updatePage";
		}
		else {
			model.addAttribute("modify", true);
			return "noPermissionPage";
			}
		}catch(Exception e) {
			return "noPermissionPage";
		}
	}
	@RequestMapping(value="ex2/updateArticle/{articleNo}")
	public String updateArticle(@PathVariable String articleNo, String title, String content)
	{
		dao.updateArticle(title, articleNo);//Article update //제목만 변경할껀지 내용만 변경할껀지 둘다 변경할껀지
		dao.updateArticleContent(articleNo, content);//Article_content update
		if(dao.updateArticle(title, articleNo)==1||dao.updateArticleContent(articleNo, content)==1)
			return "executeCompleted";
		
		else {
			return "redirect:/ex2/list";
		}
		
	}
	
	
}
