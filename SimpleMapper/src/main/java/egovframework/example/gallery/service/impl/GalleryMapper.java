package egovframework.example.gallery.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryVO;

@Mapper
public interface GalleryMapper {
	public List<?> selectGalleryList(Criteria searchVO);   
	public int selectGalleryListTotCnt(Criteria searchVO); 
	public int insert(GalleryVO galleryVO);                 
	public GalleryVO selectGallery(String  uuid);          
	public int delete(String uuid);                       
}





