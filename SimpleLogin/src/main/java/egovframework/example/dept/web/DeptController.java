package egovframework.example.dept.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.service.DeptVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@GetMapping("/dept/dept.do")
	public String selectDeptList(
			@ModelAttribute Criteria criteria,
			Model model) {
//		１） PaginationInfo: 전체 페이지수, offset 자동계산해 주는 클래스(쿼리에 필요함)
//		 => 자동계산을 위한 정보: 1) 현재페이지번호, 화면에 보여줄 개수
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());     // 현재페이지번호
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit()); // 화면에 보여줄 개수         
		
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex()); // offset 자동 계산값 넣기
		
		List<?> depts = deptService.selectDeptList(criteria);
		model.addAttribute("depts", depts);
		int totCnt = deptService.selectDeptListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);                   // 전체 행 개수
		
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "dept/dept_all";
	}

//	추가 페이지 열기 함수
	@GetMapping("/dept/addition.do")
	public String createDeptView(Model model) {
		model.addAttribute("deptVO", new DeptVO()); // 유효성 체크 모델
		return "dept/add_dept";
	}

	@PostMapping("/dept/add.do")
	public String insert(@ModelAttribute DeptVO deptVO) {
		
		log.info("테스트 " + deptVO);
		deptService.insert(deptVO);
		
		return "redirect:/dept/dept.do";
	}
	
	@GetMapping("/dept/edition.do")
	public String updateDeptView(@RequestParam int dno, Model model) 
			      {
		DeptVO deptVO = deptService.selectDept(dno);
		model.addAttribute("deptVO", deptVO);
		return "dept/update_dept";
	}
	
	@PostMapping("/dept/edit.do")
	public String update(@RequestParam int dno,
							@ModelAttribute DeptVO deptVO
			) {
		deptService.update(deptVO);
		return "redirect:/dept/dept.do"; 
	}
	
	@PostMapping("/dept/delete.do")
	public String delete(@ModelAttribute DeptVO deptVO)
	{
        deptService.delete(deptVO);
		return "redirect:/dept/dept.do"; 
	}
}






