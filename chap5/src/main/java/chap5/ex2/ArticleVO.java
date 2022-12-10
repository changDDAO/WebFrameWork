package chap5.ex2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {
	int article_no;
	int writer;
	String name;
	String title;
	String regdate;
	String moddate;
	int readcnt;

}
