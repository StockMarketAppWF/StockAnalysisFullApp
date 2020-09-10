package com.wellsfargo.uploadexcel.restcontroller;

import java.util.List;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;

public class ResponseMessage {
	private String message;
	List<StockDetailsEntity> stockInsertedDetails;

	public ResponseMessage(String message, List<StockDetailsEntity> stockInsertedDetails) {

		this.message = message;
		this.stockInsertedDetails = stockInsertedDetails;
	}
	
	public ResponseMessage(String message) {
		this.message = message;;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<StockDetailsEntity> getStockInsertedDetails() {
		return stockInsertedDetails;
	}

	public void setStockInsertedDetails(List<StockDetailsEntity> stockInsertedDetails) {
		this.stockInsertedDetails = stockInsertedDetails;
	}

}
