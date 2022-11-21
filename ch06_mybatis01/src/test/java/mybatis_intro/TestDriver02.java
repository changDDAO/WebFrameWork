package mybatis_intro;

import java.util.Date;
import java.util.List;

import yu.mybatis.model.CommentVO;
import yu.mybatis.repository.CommentMapperRepository;

public class TestDriver02 {
private final CommentMapperRepository commentMapperRepository = new CommentMapperRepository();
	
	public void testSelectCommentByPrimaryKey() {
		int commentNo = 3;
		
		CommentVO comment = commentMapperRepository.selectCommentByPrimaryKey(commentNo);
		System.out.println(comment);
	}
	
	public void testSelectManyParameters2() {
		List<CommentVO> commentList= commentMapperRepository.selectManyParameters2(2, "user2");
		for (CommentVO comment : commentList) 
			System.out.println("selectManyParameters2 : " + comment);
	}
	
	public void testSelectAllComments() {
		List<CommentVO> commentList= commentMapperRepository.selectAllComments();
		for (CommentVO comment : commentList) 
			System.out.println("selectAllComments : " + comment);
	}
	
	public void testInsertCommentAutoIncrement() {
		CommentVO comment = new CommentVO(-1, "홍길동", new Date(), "Mapper interface로 추가한 댓글");
		int result = commentMapperRepository.insertCommentAutoIncrement(comment);
		System.out.println("Mapper를 이용한 insert 결과: " + result);
	}
	
//	public void testInsertComment() {
////		CommentVO comment = new CommentVO(1, "from0", Calendar.getInstance().getTime(), "test01");
//		CommentVO comment = new CommentVO(1, "from0", new java.util.Date(), "test01");
//		int result = commentSessionRepository.insertComment(comment);
//		System.out.println("Insert 결과: " + result);
//	}
//	
//	public void testUpdateComment() {
//		CommentVO comment = new CommentVO(1, "from0", Calendar.getInstance().getTime(), "수정 - test01");
//		int result = commentSessionRepository.updateComment(comment);
//		System.out.println("Update 결과: " + result);
//	}
//	
//	public void testDeleteComment() {
//		int result = commentSessionRepository.deleteComment(1);
//		System.out.println("Delete 결과: " + result);
//	}
	
	public static void main(String[] args) {
		TestDriver02 test = new TestDriver02();
		test.testSelectCommentByPrimaryKey();
		test.testSelectAllComments();
		test.testSelectManyParameters2();
//		test.testInsertCommentAutoIncrement();
//		test.testDeleteComment();
//		test.testInsertComment();
//		test.testUpdateComment();
	}

}
