package yu.mybatis.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import yu.mybatis.model.CommentVO;

public class CommentSessionRepository extends AbstractRepository {

	public void selectTest(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			CommentVO comment = session.selectOne("yu.mybatis.mapper.CommentMapper.selectCommentByPrimaryKey", commentNo);
			System.out.println("selectOne: " + comment);
			List<CommentVO> clist = session.selectList("yu.mybatis.mapper.CommentMapper.selectSomeComments", commentNo);
			for (CommentVO item : clist) 
				System.out.println("selectList: " + item);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("commentNo", commentNo);
			params.put("uid", "user2");
			List<CommentVO> plist = session.selectList("yu.mybatis.mapper.CommentMapper.selectManyParameters1", params);
			for (CommentVO item : plist) 
				System.out.println("selectManyParameters: " + item);
		} finally {
			session.close();
		}
	}
	
	public CommentVO selectCommentByPrimaryKey(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.selectOne("yu.mybatis.mapper.CommentMapper.selectCommentByPrimaryKey", commentNo);
		} finally {
			session.close();
		}
	}
	
	public List<CommentVO> selectSomeComments(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			return session.selectList("yu.mybatis.mapper.CommentMapper.selectSomeComments", commentNo);
		} finally {
			session.close();
		}
	}
	
	public int insertComment(CommentVO comment) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			int result = session.insert("yu.mybatis.mapper.CommentMapper.insertComment", comment);
			if (result > 0)
				session.commit();
			return result;
		} finally {
			session.close();
		}
	}
	
	public int updateComment(CommentVO comment) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			int result = session.update("yu.mybatis.mapper.CommentMapper.updateComment", comment);
			if (result > 0)
				session.commit();
			return result;
		} finally {
			session.close();
		}
	}
	
	public int deleteComment(int comment_no) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			int result = session.delete("yu.mybatis.mapper.CommentMapper.deleteComment", comment_no);
			if (result > 0)
				session.commit();
			return result;
		} finally {
			session.close();
		}
	}
}
