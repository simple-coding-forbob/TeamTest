package egovframework.example.faq.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqService;
import egovframework.example.faq.service.FaqVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	@GetMapping("/faq/faq.do")
	public String selectFaqList(
			@ModelAttribute Criteria criteria,
			Model model) {
//		１） PaginationInfo: 전체 페이지수, offset 자동계산해 주는 클래스(쿼리에 필요함)
//		 => 자동계산을 위한 정보: 1) 현재페이지번호, 화면에 보여줄 개수
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());     // 현재페이지번호
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit()); // 화면에 보여줄 개수         
		
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex()); // offset 자동 계산값 넣기
		
		List<?> faqs = faqService.selectFaqList(criteria);
		model.addAttribute("faqs", faqs);
		int totCnt = faqService.selectFaqListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);                   // 전체 행 개수
		
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "faq/faq_all";
	}

//	추가 페이지 열기 함수
	@GetMapping("/faq/addition.do")
	public String createFaqView(Model model) {
		model.addAttribute("faqVO", new FaqVO()); // 유효성 체크 모델
		return "faq/add_faq";
	}

	@PostMapping("/faq/add.do")
	public String insert(@ModelAttribute FaqVO faqVO) {
		
		log.info("테스트 " + faqVO);
		faqService.insert(faqVO);
		
		return "redirect:/faq/faq.do";
	}
	
	@GetMapping("/faq/edition.do")
	public String updateFaqView(@RequestParam int fno, Model model) 
			      {
		FaqVO faqVO = faqService.selectFaq(fno);
		model.addAttribute("faqVO", faqVO);
		return "faq/update_faq";
	}
	
	@PostMapping("/faq/edit.do")
	public String update(@RequestParam int fno,
							@ModelAttribute FaqVO faqVO
			) {
		faqService.update(faqVO);
		return "redirect:/faq/faq.do"; 
	}
	
	@PostMapping("/faq/delete.do")
	public String delete(@ModelAttribute FaqVO faqVO)
	{
        faqService.delete(faqVO);
		return "redirect:/faq/faq.do"; 
	}
}






