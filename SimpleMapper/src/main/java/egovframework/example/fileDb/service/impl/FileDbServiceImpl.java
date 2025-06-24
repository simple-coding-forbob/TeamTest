package egovframework.example.fileDb.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbService;
import egovframework.example.fileDb.service.FileDbVO;

@Service
public class FileDbServiceImpl implements FileDbService {

	@Autowired
	FileDbMapper fileDbMapper;

	@Override
	public List<?> selectFileDbList(Criteria searchVO) {
		return fileDbMapper.selectFileDbList(searchVO);
	}
	
	@Override
	public int selectFileDbListTotCnt(Criteria searchVO) {
		return fileDbMapper.selectFileDbListTotCnt(searchVO);
	}
	
	@Override
	public void insert(FileDbVO fileDbVO) {
		    String newUuid = UUID.randomUUID().toString(); 
		    String fileDownloadURL = generateDownloadUrl(newUuid);
		    fileDbVO.setUuid(newUuid);
		    fileDbVO.setFileUrl(fileDownloadURL);
		    
		    fileDbMapper.insert(fileDbVO);
	}
	
	public String generateDownloadUrl(String uuid) {
        return ServletUriComponentsBuilder      
          .fromCurrentContextPath()
          .path("/fileDb/download.do")
          .query("uuid="+uuid)
          .toUriString();
	}
	
	@Override
	public FileDbVO selectFileDb(String uuid) {
		FileDbVO fileDbVO = fileDbMapper.selectFileDb(uuid);
		return fileDbVO;
	}
	
	@Override
	public void delete(String uuid) {
		fileDbMapper.delete(uuid);
	}
}

