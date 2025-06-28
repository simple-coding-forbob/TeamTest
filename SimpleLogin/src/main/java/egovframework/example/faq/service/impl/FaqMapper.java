/**
 * 
 */
package egovframework.example.faq.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqVO;

/**
 * @author TaeGyung
 *
 */
@Mapper
public interface FaqMapper {
	public List<?> selectFaqList(Criteria searchVO);   // 전체 조회
	public int selectFaqListTotCnt(Criteria searchVO); // 개수 세기
	public int insert(FaqVO faqVO);                   // insert 함수
	public FaqVO selectFaq(int dno);                  // 상세조회 함수
	public int update(FaqVO faqVO);                   // update 함수
	public int delete(FaqVO faqVO);                   // delete 함수
}