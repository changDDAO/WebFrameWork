package mybatis_intro;

import java.util.Calendar;
import java.util.List;

import yu.mybatis.model.CommentVO;
import yu.mybatis.repository.CommentSessionRepository;

public class TestDriver01 {
	private final CommentSessionRepository commentSessionRepository = new CommentSessionRepository();
	
	public void testSelect() {
		int commentNo = 3;
		commentSessionRepository.selectTest(commentNo);
	}
	
	public void testSelectCommentByPrimaryKey() {
		int commentNo = 3;
		
		CommentVO comment = commentSessionRepository.selectCommentByPrimaryKey(commentNo);
		System.out.println(comment);
	}
	
	public void testSelectSomeComments() {
		int commentNo = 3;
		
		List<CommentVO> comments = commentSessionRepository.selectSomeComments(commentNo);
		System.out.println("Comment number가 3이상인 comment들: ");
		for (CommentVO comment : comments)
			System.out.println("\t" + comment);
	}
	
	public void testInsertComment() {
//		CommentVO comment = new CommentVO(1, "from0", Calendar.getInstance().getTime(), "test01");
		CommentVO comment = new CommentVO(1, "from0", new java.util.Date(), "test01");
		int result = commentSessionRepository.insertComment(comment);
		System.out.println("Insert 결과: " + result);
	}
	
	public void testUpdateComment() {
		CommentVO comment = new CommentVO(1, "from0", Calendar.getInstance().getTime(), "수정 - test01");
		int result = commentSessionRepository.updateComment(comment);
		System.out.println("Update 결과: " + result);
	}
	
	public void testDeleteComment() {
		int result = commentSessionRepository.deleteComment(1);
		System.out.println("Delete 결과: " + result);
	}
	
	public static void main(String[] args) {
		TestDriver01 test = new TestDriver01();
		test.testSelect();
//		test.testSelectCommentByPrimaryKey();
//		test.testSelectSomeComments();
//		test.testDeleteComment();
//		test.testInsertComment();
//		test.testUpdateComment();
		
	}

}
