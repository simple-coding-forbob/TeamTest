/**
 * 
 */
package egovframework.example.dept.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.service.DeptVO;

@Service
public class DeptServiceImpl extends EgovAbstractServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<?> selectDeptList(Criteria searchVO) {
		return deptMapper.selectDeptList(searchVO);
	}
	
	@Override
	public int selectDeptListTotCnt(Criteria searchVO) {
		return deptMapper.selectDeptListTotCnt(searchVO);
	}
	
	@Override
	public void insert(DeptVO deptVO) {
		deptMapper.insert(deptVO);
	}
	
	@Override
	public DeptVO selectDept(int dno) {
		DeptVO deptVO = deptMapper.selectDept(dno);
		return deptVO;
	}

	@Override
	public void update(DeptVO deptVO) {
		deptMapper.update(deptVO);
	}

	@Override
	public void delete(DeptVO deptVO) {
		deptMapper.delete(deptVO);
	}
}








