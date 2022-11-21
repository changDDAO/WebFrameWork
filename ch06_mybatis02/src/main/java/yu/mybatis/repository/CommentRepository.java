package yu.mybatis.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yu.mybatis.mapper.CommentMapper;
import yu.mybatis.model.CommentReplies;
import yu.mybatis.model.CommentUser;
import yu.mybatis.model.CommentVO;

@Repository
public class CommentRepository {
	@Autowired
	private SqlSessionTemplate session;
//	@Autowired
//	private CommentMapper commentMapper;

	public List<CommentVO> selectSomeComments(int commentNo) {
		return session.selectList("yu.mybatis.mapper.CommentMapper.selectSomeComments", commentNo);
	}
	
	public CommentVO selectCommentByPrimaryKey(int commentNo) {
		return session.selectOne("yu.mybatis.mapper.CommentMapper.selectCommentByPrimaryKey", commentNo);
	}
	
	public int selectMaxCommentNo() {
		return session.selectOne("yu.mybatis.mapper.CommentMapper.selectMaxCommentNo");
	}
	
	public List<CommentVO> selectAllComments() {
		return session.getMapper(CommentMapper.class).selectAllComments();
//		return commentMapper.selectAllComments();
	}
	
	public int insertComment(CommentVO comment) {
		int result = session.insert("yu.mybatis.mapper.CommentMapper.insertComment", comment);
//		if (result > 0)
//			session.commit();	// Manual commit is not allowed over a Spring managed SqlSession
		return result;
	}
	
	public int updateComment(CommentVO comment) {
		int result = session.update("yu.mybatis.mapper.CommentMapper.updateComment", comment);
//		if (result > 0)
//			session.commit();	// Manual commit is not allowed over a Spring managed SqlSession
		return result;
	}
	
	public int deleteComment(int comment_no) {
		int result = session.delete("yu.mybatis.mapper.CommentMapper.deleteComment", comment_no);
//		if (result > 0)
//			session.commit();	// Manual commit is not allowed over a Spring managed SqlSession
		return result;
	}
	
	public CommentVO selectCommentResulpMapping(int commentNo) {
		return session.selectOne("ResultMapMapping.selectCommentByPrimaryKey", commentNo);
	}
	
	public CommentVO selectCommentConstructor(int commentNo) {
		return session.selectOne("ResultMapMapping.selectCommentByPrimaryKeyConstructor", commentNo);
	}
	
	public CommentUser selectCommentUser(int commentNo) {
		return session.selectOne("ResultMapMapping.selectCommentUser", commentNo);
	}
	
	public CommentReplies selectCommentReplies(int commentNo) {
		return session.selectOne("ResultMapMapping.selectCommentReplies", commentNo);
	}
}
