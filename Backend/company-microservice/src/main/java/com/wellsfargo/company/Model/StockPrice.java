package com.wellsfargo.company.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	private float price;
	private Date date;
	private Time time;
	private Integer company_id;
	private Integer exchange_id;

	public StockPrice() {

	}

	public StockPrice(int stockId, float price, Date date, Time time, Integer company_id, Integer exchange_id) {

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
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
