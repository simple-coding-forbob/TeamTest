/**
 * 
 */
package egovframework.example.fileDb.web;

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
import egovframework.example.fileDb.service.FileDbService;
import egovframework.example.fileDb.service.FileDbVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FileDbController {

	@Autowired
	FileDbService fileDbService;

	@GetMapping("/fileDb/fileDb.do")
	public String selectFileDbList(@ModelAttribute Criteria criteria, Model model) {
		
		PaginationInfo paginationInfo = new PaginationInfo();         
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());     
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());          
		
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());           

		List<?> fileDBs = fileDbService.selectFileDbList(criteria);
		model.addAttribute("fileDBs", fileDBs);
		
		int totCnt = fileDbService.selectFileDbListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "fileDb/fileDb_all";
	}

//	추가 페이지 열기 :
	@GetMapping("/fileDb/addition.do")
	public String createFileDbView() {
		return "fileDb/add_fileDb";
	}
	
	@PostMapping("/fileDb/add.do")
	public String insert(@RequestParam(defaultValue = "") String fileTitle,
							@RequestParam(defaultValue = "") String fileContent,
							@RequestParam(required = false) MultipartFile image
			) throws Exception {
		FileDbVO fileDbVO = new FileDbVO(fileTitle, fileContent, image.getBytes());
		fileDbService.insert(fileDbVO);
		return "redirect:/fileDb/fileDb.do"; 
	}
	
	@GetMapping("/fileDb/download.do")
	@ResponseBody
	public ResponseEntity<byte[]> findDownload(@RequestParam(defaultValue = "") String uuid) {
		FileDbVO fileDbVO = fileDbService.selectFileDb(uuid);
		
        HttpHeaders headers = new HttpHeaders();             
        headers.setContentDispositionFormData("attachment", fileDbVO.getUuid()); 
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);              

        return new ResponseEntity<byte[]>(fileDbVO.getFileData(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/fileDb/delete.do")
	public String delete(@RequestParam(defaultValue = "") String uuid) {
		log.info("테스트 : " + uuid);
		fileDbService.delete(uuid);
		return "redirect:/fileDb/fileDb.do"; 
	}
}









