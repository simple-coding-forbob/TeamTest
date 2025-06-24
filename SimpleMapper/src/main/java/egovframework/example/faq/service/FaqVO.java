/**
 * 
 */
package egovframework.example.faq.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FaqVO extends Criteria {
	private int fno;           // 번호(기본키)
	private String title;      // 제목
	private String content;    // 내용
}






