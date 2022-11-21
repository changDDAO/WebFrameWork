package yu.mybatis.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
	private int commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
}
