package yu.mybatis.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import yu.mybatis.mapper.CommentMapper;
import yu.mybatis.model.CommentVO;

public class CommentMapperRepository {
	private SqlSessionFactory sqlSessionFactory;
	
	public CommentMapperRepository() {
		sqlSessionFactory = getSqlSessionFactory();
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public CommentVO selectCommentByPrimaryKey(int commentNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(CommentMapper.class).selectCommentByPrimaryKey(commentNo);
		} finally {
			session.close();
		}
	}
	
	public List<CommentVO> selectManyParameters2(int commentNo, String uid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(CommentMapper.class).selectManyParameters2(commentNo, uid);
		} finally {
			session.close();
		}
	}
	
	public List<CommentVO> selectAllComments() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(CommentMapper.class).selectAllComments();
		} finally {
			session.close();
		}
	}
	
	public int insertCommentAutoIncrement(CommentVO comment) {
		SqlSession session = sqlSessionFactory.openSession(true);
		try {
			return session.getMapper(CommentMapper.class).insertCommentAutoIncrement(comment);
		} finally {
			session.close();
		}
	}
}
