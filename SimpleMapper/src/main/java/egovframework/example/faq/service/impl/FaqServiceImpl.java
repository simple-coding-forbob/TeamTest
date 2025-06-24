/**
 * 
 */
package egovframework.example.faq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqService;
import egovframework.example.faq.service.FaqVO;

@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqMapper faqMapper;

	@Override
	public List<?> selectFaqList(Criteria criteria) {
		return faqMapper.selectFaqList(criteria);
	}
	
	@Override
	public int selectFaqListTotCnt(Criteria criteria) {
		return faqMapper.selectFaqListTotCnt(criteria);
	}
	
	@Override
	public void insert(FaqVO faqVO) {
		faqMapper.insert(faqVO);
	}
	
	@Override
	public FaqVO selectFaq(int fno) {
		FaqVO faqVO = faqMapper.selectFaq(fno);
		return faqVO;
	}

	@Override
	public void update(FaqVO faqVO) {
		faqMapper.update(faqVO);
	}

	@Override
	public void delete(FaqVO faqVO) {
		faqMapper.delete(faqVO);
	}
}








