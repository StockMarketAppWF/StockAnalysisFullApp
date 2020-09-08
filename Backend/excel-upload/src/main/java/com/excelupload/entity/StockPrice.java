package com.excelupload.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stock_price_table")
public class StockPrice {
	
	  @Id
	  private int id;
	 
	  @Column(name ="company_code",length=50)
	  private String companyCode;
	  
	  @Column(name="stock_exchange")
	  private String stockExchange;
	  
	  @Column(name="current_price")
	  private float currentPrice;
	  
	  @Column(name="date")
	  LocalDate date;
	  
	  @Column(name="time")
	  String time;
	  
	  public StockPrice(){}

	  public StockPrice(String companyCode, String stockExchange, float currentPrice, LocalDate date, String time) {
		super();
		this.companyCode= companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyId(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchnage) {
		this.stockExchange = stockExchnage;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [companyCode=" + companyCode + ", stockExchnage=" + stockExchange + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}

}
