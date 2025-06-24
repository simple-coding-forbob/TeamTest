package egovframework.example.fileDb.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbVO;

@Mapper
public interface FileDbMapper {
	public List<?> selectFileDbList(Criteria searchVO);   
	public int selectFileDbListTotCnt(Criteria searchVO); 
	public int insert(FileDbVO fileDbVO);                 
	public FileDbVO selectFileDb(String  uuid);           
	public int delete(String uuid);                       
}





