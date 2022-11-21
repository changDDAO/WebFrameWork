package yu.mybatis.model;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private int commentNo;
	private String userId;
	private String replyContent;
	private Date regDate;
}
