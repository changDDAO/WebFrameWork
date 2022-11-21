package yu.mybatis.model;

import lombok.Data;

@Data
public class CommentUser {
	private CommentVO comment;
	private UserVO user;
}
