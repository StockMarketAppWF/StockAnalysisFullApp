package com.wellsfargo.uploadexcel.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;

public interface StockDetailsDAO {
	public List<StockDetailsEntity> save(List<StockDetailsEntity> stockDetailsFromExcelList);
}
