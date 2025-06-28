/**
 * 
 */
package egovframework.example.faq.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface FaqService {
	List<?> selectFaqList(Criteria criteria);
	int selectFaqListTotCnt(Criteria criteria);     
	void insert(FaqVO faqVO); 
	FaqVO selectFaq(int fno);     
	void update(FaqVO faqVO); 
	void delete(FaqVO faqVO);
}










