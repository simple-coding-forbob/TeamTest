/**
 * 
 */
package egovframework.example.faq.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqService;
import lombok.extern.log4j.Log4j;

/**
 * @author simple-coding
 * AutoComplete
 */
@Log4j
@RestController
public class FaqAjaxController {
	@Autowired
	private FaqService faqService;

	@GetMapping("/api/faq/faq.do")
	public List<?> selectFaqList(@ModelAttribute("searchVO") Criteria criteria) throws Exception {
		criteria.setFirstIndex(0); // 첫페이지만
		List<?> list = faqService.selectFaqList(criteria);
		
		return list;
	}	
}
