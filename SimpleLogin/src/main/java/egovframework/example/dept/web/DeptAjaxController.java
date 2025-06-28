/**
 * 
 */
package egovframework.example.dept.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import lombok.extern.log4j.Log4j;

/**
 * @author simple-coding
 * AutoComplete
 */
@Log4j
@RestController
public class DeptAjaxController {
	@Autowired
	private DeptService deptService;

	@GetMapping("/api/dept/dept.do")
	public List<?> selectDeptList(@ModelAttribute("searchVO") Criteria criteria) throws Exception {        
		
		criteria.setFirstIndex(0); // 첫페이지만
		List<?> list = deptService.selectDeptList(criteria);
		
		return list;
	}	
}
