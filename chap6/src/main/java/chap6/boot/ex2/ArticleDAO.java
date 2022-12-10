package chap6.boot.ex2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDAO {
	@Autowired
	JdbcTemplate template;
	
	public List<ArticleVO> getAllArticles(){
		String sql = "select a.article_no, a.writer, m.name, a.title, a.regdate, a.moddate, a.read_cnt from article a, member m where a.writer = m.id";
		
		List<ArticleVO> articles = template.query(sql, (rs, rowNum)->
		new ArticleVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(7)));
		return articles;
	}
	public int addArticle(int writer , String title) {
		String query = "insert into article(writer, title, regdate,read_cnt)values (?,?,SYSDATE(),0)";
		return template.update(query, writer,title);
	}
	
	public int get_articleNum(int id , String title) {
		String query = "select article_no from article where writer = ? and title = ?";
		return template.queryForObject(query, new BeanPropertyRowMapper<ArticleVO>(ArticleVO.class),id, title).article_no;
	}
	
	public int addArticleContent(int articleNo, String content) {
		String query = "insert into article_content(article_no,content) values(?,?)";
		return template.update(query,articleNo, content );
	}
	
	public ArticleVO getArticleByNo(String articleNo) {
		String query = "select * from article where article_no = ?";
		ArticleVO article = template.queryForObject(query, new BeanPropertyRowMapper<ArticleVO>(ArticleVO.class),articleNo);
		return article;
	}
	public String getNameByWriter(int writer) {
		String query = "select name from member where id = ?";
		MemberVO member = template.queryForObject(query, new BeanPropertyRowMapper<MemberVO>(MemberVO.class),writer);
		return member.name;
	}
	public String getContent(String articleNo) {
		String query = "select content from article_content where article_no = ?";
		ArticleContentVO articleContent = template.queryForObject(query, new BeanPropertyRowMapper<ArticleContentVO>(ArticleContentVO.class),articleNo);
		return articleContent.content;
		}
	public int plusReadCnt(String articleNo) {
		String query = "update article set read_cnt = read_cnt+1 where article_no = ?";
		return template.update(query, articleNo);
	}
	public int updateArticleContent(String articleNo,String content ) {
		String query = "update article_content set content = ? where article_no = ?";
		return template.update(query, content,articleNo);
	}
	
	public int updateArticle(String title, String articleNo) {
		String query = "update article set title = ? , moddate = SYSDATE() where article_no = ?";
		return template.update(query, title, articleNo);
	}
	public int delArticle(String articleNo) {
		String query = "delete from article where article_no = ?";
		return template.update(query, articleNo);
	}
	
	}

