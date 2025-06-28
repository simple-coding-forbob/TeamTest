/**
 * 
 */
package egovframework.example.gallery.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryService;
import egovframework.example.gallery.service.GalleryVO;

@Controller
public class GalleryController {

	@Autowired
	GalleryService galleryService; 

	@GetMapping("/gallery/gallery.do")
	public String selectGalleryList(@ModelAttribute Criteria criteria, Model model) {

		PaginationInfo paginationInfo = new PaginationInfo(); 
		paginationInfo.setCurrentPageNo(criteria.getPageIndex()); 
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());  

		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex()); 

		List<?> gallerys = galleryService.selectGalleryList(criteria);
		model.addAttribute("gallerys", gallerys);
		
		int totCnt = galleryService.selectGalleryListTotCnt(criteria);		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "gallery/gallery_all";
	}
	
	@GetMapping("/gallery/addition.do")
	public String createGalleryView() {
		return "gallery/add_gallery";
	}
	
	@PostMapping("/gallery/add.do")
	public String insert(@RequestParam(defaultValue = "") String galleryTitle,
							@RequestParam(required = false) MultipartFile image
			) throws Exception {
		GalleryVO galleryVO = new GalleryVO(galleryTitle, image.getBytes());
		galleryService.insert(galleryVO);
		return "redirect:/gallery/gallery.do"; 
	}
	
	@GetMapping("/gallery/download.do")
	@ResponseBody
	public ResponseEntity<byte[]> findDownload(@RequestParam(defaultValue = "") String uuid) {
		GalleryVO galleryVO = galleryService.selectGallery(uuid);
		
        HttpHeaders headers = new HttpHeaders();             
        headers.setContentDispositionFormData("attachment", galleryVO.getUuid()); 
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);              

        return new ResponseEntity<byte[]>(galleryVO.getGalleryData(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/gallery/delete.do")
	public String delete(@RequestParam(defaultValue = "") String uuid) {
		galleryService.delete(uuid);
		return "redirect:/gallery/gallery.do";
	}
}
