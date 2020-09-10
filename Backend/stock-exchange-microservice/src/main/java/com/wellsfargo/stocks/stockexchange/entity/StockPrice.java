package com.wellsfargo.stocks.stockexchange.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.sql.Time;

@Entity
public class StockPrice {
	@Id
	private int stockId;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private Time time;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "exchange_id")
	private Exchange exchange;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
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

}
