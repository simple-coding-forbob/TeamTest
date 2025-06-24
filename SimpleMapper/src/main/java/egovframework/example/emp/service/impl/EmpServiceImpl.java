/**
 * 
 */
package egovframework.example.emp.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.emp.service.EmpService;
import egovframework.example.emp.service.EmpVO;

@Service
public class EmpServiceImpl extends EgovAbstractServiceImpl implements EmpService{
	
	@Autowired
	EmpMapper empMapper; 
	
	@Override
	public List<?> selectEmpList(Criteria searchVO) {
		return empMapper.selectEmpList(searchVO);
	}

	@Override
	public int selectEmpListTotCnt(Criteria searchVO) {
		return empMapper.selectEmpListTotCnt(searchVO);
	}
	
	@Override
	public void insert(EmpVO empVO) {
		empMapper.insert(empVO);
	}
	
	@Override
	public EmpVO selectEmp(int eno) {
		EmpVO empVO = empMapper.selectEmp(eno);
		return empVO;
	}
	
	@Override
	public void update(EmpVO empVO) {
		empMapper.update(empVO);
	}
	
	@Override
	public void delete(EmpVO empVO) {
		empMapper.delete(empVO);
	}
}






