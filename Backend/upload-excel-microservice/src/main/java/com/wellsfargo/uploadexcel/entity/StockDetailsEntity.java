package com.wellsfargo.uploadexcel.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="stock_price")
@Table(schema = "stock_price")
public class StockDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id")
	private int stockId;
	
	@Column(name = "price")
	private float price;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "company_id")
	private Integer company_id;
	@Column(name = "exchange_id")
	private Integer exchange_id;
	


	public StockDetailsEntity() {

	}

	public StockDetailsEntity(int stockId, float price, LocalDate date, LocalTime time, Integer company_id, Integer exchange_id) {

		this.stockId = stockId;
		this.price = price;
		this.date = date;
		this.time = time;
		this.company_id = company_id;
		this.exchange_id = exchange_id;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime localTime) {
		this.time = localTime;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public Integer getExchange_id() {
		return exchange_id;
	}

	public void setExchange_id(Integer exchange_id) {
		this.exchange_id = exchange_id;
	}

}
