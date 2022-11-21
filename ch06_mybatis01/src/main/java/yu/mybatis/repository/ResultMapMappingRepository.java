package yu.mybatis.repository;

import org.apache.ibatis.session.SqlSession;

import yu.mybatis.model.CommentReplies;
import yu.mybatis.model.CommentUser;
import yu.mybatis.model.CommentVO;

public class ResultMapMappingRepository extends AbstractRepository {
	public CommentVO selectCommentByPrimaryKey(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			System.out.println("selectCommentByPrimaryKey");
			CommentVO comment = session.selectOne("ResultMapMapping.selectCommentByPrimaryKey", commentNo);
			return comment;
		} finally {
			session.close();
		}
	}
	
	public CommentVO selectCommentByPrimaryKeyConstructor(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			System.out.println("selectCommentByPrimaryKeyConstructor");
			CommentVO comment = session.selectOne("ResultMapMapping.selectCommentByPrimaryKeyConstructor", commentNo);
			return comment;
		} finally {
			session.close();
		}
	}
	
	public CommentUser selectCommentUser(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			CommentUser cu = session.selectOne("ResultMapMapping.selectCommentUser", commentNo);
			return cu;
		} finally {
			session.close();
		}
	}
	
	public CommentReplies selectCommentReplies(int commentNo) {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			CommentReplies cr = session.selectOne("ResultMapMapping.selectCommentReplies", commentNo);
			return cr;
		} finally {
			session.close();
		}
	}
}
