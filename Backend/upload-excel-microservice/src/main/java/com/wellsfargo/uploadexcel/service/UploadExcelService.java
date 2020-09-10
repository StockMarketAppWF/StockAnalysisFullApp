package com.wellsfargo.uploadexcel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;

public interface UploadExcelService {
	public List<StockDetailsEntity> save(MultipartFile stockDetailsFromExcel);
}
	