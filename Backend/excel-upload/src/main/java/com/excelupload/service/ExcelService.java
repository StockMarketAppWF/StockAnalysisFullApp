package com.excelupload.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excelupload.entity.StockPrice;
import com.excelupload.helper.ExcelHelper;
import com.excelupload.repository.StockPriceRepository;

@Service
public class ExcelService {
	
	@Autowired
	  StockPriceRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<StockPrice> stockprices = ExcelHelper.excelToStockPrices(file.getInputStream());
	      repository.saveAll(stockprices);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<StockPrice> getAllStockPrices() {
	    return repository.findAll();
	  }

}
