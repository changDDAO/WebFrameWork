package yu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import yu.mybatis.model.CommentVO;

public interface CommentMapper {
	CommentVO selectCommentByPrimaryKey(int commentNo);
//	List<CommentVO> selectManyParameters2(int commentNo, String uid);
	List<CommentVO> selectManyParameters2(@Param("cno") int comNo, @Param("uid") String uid);
	
//	@Select({"select * from comment"})
//	@Results({
//		@Result(column="comment_no", property="commentNo", jdbcType=JdbcType.INTEGER, id=true),
//		@Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
//		@Result(column="reg_date", property="regDate", jdbcType=JdbcType.TIMESTAMP),
//		@Result(column="comment_content", property="commentContent", jdbcType=JdbcType.LONGVARCHAR)
//	})
	@Select({"select * from comment"})
	@Results({
		@Result(column="comment_no", property="commentNo", id=true),
		@Result(column="user_id", property="userId"),
		@Result(column="reg_date", property="regDate"),
		@Result(column="comment_content", property="commentContent")
	})
	List<CommentVO> selectAllComments();
	
	@Insert({"insert into comment(user_id, comment_content, reg_date) ",
			 "values(#{userId}, #{commentContent}, #{regDate})"})
	int insertCommentAutoIncrement(CommentVO comment);
}
