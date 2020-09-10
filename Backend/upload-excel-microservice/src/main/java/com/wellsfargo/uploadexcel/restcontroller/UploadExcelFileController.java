
package com.wellsfargo.uploadexcel.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;
import com.wellsfargo.uploadexcel.helper.ExcelHelper;
import com.wellsfargo.uploadexcel.service.UploadExcelService;
import com.wellsfargo.uploadexcel.util.UploadExcelUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/excel")
public class UploadExcelFileController {

	private UploadExcelService uploadExcelService;

	@Autowired
	public UploadExcelFileController(UploadExcelService uploadExcelService) {
		this.uploadExcelService = uploadExcelService;
	}

	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("excel") MultipartFile file) {
	    String message = "";
	    List<StockDetailsEntity> returnedResults;

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  returnedResults = uploadExcelService.save(file);
	        message = UploadExcelUtil.FILE_UPLOAD_SUCCESSFUL_MESSAGE + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, returnedResults));
	      } catch (Exception e) {
	    	  e.printStackTrace();
	        message = UploadExcelUtil.FILE_UPLOAD_FAILED_MESSAGE + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	    
	    message = UploadExcelUtil.UPLOAD_FILE_MESSAGE;
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	 }
}