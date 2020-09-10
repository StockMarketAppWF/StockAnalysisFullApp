package com.wellsfargo.uploadexcel.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.dao.StockDetailsDAO;
import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;
import com.wellsfargo.uploadexcel.helper.ExcelHelper;
import com.wellsfargo.uploadexcel.util.UploadExcelUtil;

@Service
public class UploadExcelServiceImpl implements UploadExcelService {

	private StockDetailsDAO stockDAO;
	
	@Autowired
	public UploadExcelServiceImpl(StockDetailsDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Override
	@Transactional
	public List<StockDetailsEntity> save(MultipartFile stockDetailsFromExcel) {
		try {
		     List<StockDetailsEntity> details = ExcelHelper.excelToStockDetailsFromExcel(stockDetailsFromExcel.getInputStream());
		      return stockDAO.save(details);
		}catch (RuntimeException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}