/**
 * 
 */
package egovframework.example.gallery.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryService;
import egovframework.example.gallery.service.GalleryVO;

@Service
public class GalleryServiceImpl implements GalleryService {
	
	@Autowired
	GalleryMapper galleryMapper;

	@Override
	public List<?> selectGalleryList(Criteria searchVO) {
		return galleryMapper.selectGalleryList(searchVO);
	}
	
	@Override
	public int selectGalleryListTotCnt(Criteria searchVO) {
		return galleryMapper.selectGalleryListTotCnt(searchVO);
	}
	
	@Override
	public void insert(GalleryVO galleryVO) {
		    String newUuid = UUID.randomUUID().toString(); 
		    String fileDownloadURL = generateDownloadUrl(newUuid);
		    galleryVO.setUuid(newUuid);
		    galleryVO.setGalleryFileUrl(fileDownloadURL);
		    
		    galleryMapper.insert(galleryVO);
	}
	
	public String generateDownloadUrl(String uuid) {
        return ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/gallery/download.do")
          .query("uuid="+uuid)
          .toUriString();
	}
	
	@Override
	public GalleryVO selectGallery(String uuid) {
		GalleryVO galleryVO = galleryMapper.selectGallery(uuid);
		return galleryVO;
	}
	
	@Override
	public void delete(String uuid) {
		galleryMapper.delete(uuid);
	}
}






