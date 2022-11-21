package yu.mybatis.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CommentReplies {
	private int commentNo;	// int로 하면 <constructor>가 오류
	private String userId;
	private Date regDate;
	private String commentContent;
	List<ReplyVO> replies;
}
