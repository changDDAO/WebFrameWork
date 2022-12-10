package chap6.boot.ex2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleContentVO {
	int article_no;
	String content;

}
