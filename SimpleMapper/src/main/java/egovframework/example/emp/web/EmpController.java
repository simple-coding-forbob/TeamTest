package egovframework.example.emp.web;

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
import egovframework.example.emp.service.EmpService;
import egovframework.example.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService; 
	
	@GetMapping("/emp/emp.do")
	public String selectEmpList(@ModelAttribute Criteria criteria,
			Model model
			) {
		PaginationInfo paginationInfo = new PaginationInfo();         
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());          
		
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());          
		List<?> emps = empService.selectEmpList(criteria); 
		model.addAttribute("emps", emps);
		
		int totCnt = empService.selectEmpListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "emp/emp_all";
	}
	
	@GetMapping("/emp/addition.do")
	public String createEmpView(Model model) {
		model.addAttribute("empVO", new EmpVO()); // 유효성 체크 모델
		return "emp/add_emp";
	}
	
	@PostMapping("/emp/add.do")
	public String insert(@ModelAttribute EmpVO empVO) {
		empService.insert(empVO);
		
		return "redirect:/emp/emp.do"; 
	}
	

	@GetMapping("/emp/edition.do")
	public String updateEmpView(@RequestParam int eno, Model model) {
		EmpVO empVO = empService.selectEmp(eno);
		model.addAttribute("empVO", empVO);
		return "emp/update_emp";
	}
	
	@PostMapping("/emp/edit.do")
	public String update(@RequestParam int eno,
							@ModelAttribute EmpVO empVO
			) {
		empService.update(empVO);
		return "redirect:/emp/emp.do"; 
	}
	
	@PostMapping("/emp/delete.do")
	public String delete(@ModelAttribute EmpVO empVO) {
        empService.delete(empVO);
		return "redirect:/emp/emp.do"; 
	}
}









