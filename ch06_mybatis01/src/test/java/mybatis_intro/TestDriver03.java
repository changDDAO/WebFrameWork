package mybatis_intro;

import yu.mybatis.model.CommentReplies;
import yu.mybatis.model.CommentUser;
import yu.mybatis.model.CommentVO;
import yu.mybatis.model.ReplyVO;
import yu.mybatis.repository.ResultMapMappingRepository;

public class TestDriver03 {
	private final ResultMapMappingRepository repository = new ResultMapMappingRepository();
	
	public void testSelectCommentByPrimaryKey() {
		CommentVO comment = repository.selectCommentByPrimaryKey(1);
		System.out.println(comment);
	}
	
	public void testSelectCommentByPrimaryKeyConstructore() {
		CommentVO comment = repository.selectCommentByPrimaryKeyConstructor(1);
		System.out.println(comment);
	}
	
	public void testSelectCommentUser() {
		CommentUser cu = repository.selectCommentUser(1);
		System.out.println("CommentUser의 Comment: " + cu.getComment());
		System.out.println("CommentUser의 User: " + cu.getUser());
	}
	
	public void testSelectCommentReplies() {
		CommentReplies cr = repository.selectCommentReplies(1);
		System.out.println("CommentReplies의 Comment: " + cr.getCommentNo());
		System.out.println("CommentUser의 Reply들: ");
		for (ReplyVO reply : cr.getReplies())
			System.out.println("\t\t" + reply);
	}
	
	public static void main(String[] args) {
		TestDriver03 test = new TestDriver03();

		test.testSelectCommentByPrimaryKey();
		test.testSelectCommentByPrimaryKeyConstructore();
		test.testSelectCommentUser();
		test.testSelectCommentReplies();
	}

}
