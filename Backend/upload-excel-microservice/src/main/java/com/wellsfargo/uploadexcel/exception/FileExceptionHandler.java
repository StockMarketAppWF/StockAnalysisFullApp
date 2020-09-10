package com.wellsfargo.uploadexcel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wellsfargo.uploadexcel.restcontroller.ResponseMessage;
import com.wellsfargo.uploadexcel.util.UploadExcelUtil;

@ControllerAdvice
public class FileExceptionHandler extends ResponseEntityExceptionHandler{
	
	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(UploadExcelUtil.FILE_LARGE_EXCEPTION_MESSAGE));
	  }
}
