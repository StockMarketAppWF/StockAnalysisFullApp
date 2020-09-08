package com.wellsfargo.stockexchange.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="ceo")
	String ceo;
	
	@Column(name="sector_id")
    String sectorId;
	
	@Column(name="brief")
	String brief;
	
	@Column(name="code")
	String code;
	
	@Column(name="stock_exchange_id")
	int stockExchangeId;
	
	@Column(name="board")
	String board;
	
	@Column(name="turnover")
	long turnover;
	
	Company(){}

	public Company(int id, String name, String ceo, String sectorId, String brief, String code, int stockExchangeId,
			String board, long turnover) {
		super();
		this.id = id;
		this.name = name;
		this.ceo = ceo;
		this.sectorId = sectorId;
		this.brief = brief;
		this.code = code;
		this.stockExchangeId = stockExchangeId;
		this.board = board;
		this.turnover = turnover;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	public int getStockExchangeId() {
		return stockExchangeId;
	}

	public void setStockExchangeId(int stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", ceo=" + ceo + ", sectorId=" + sectorId + ", brief=" + brief
				+ ", code=" + code + ", stockExchangeId=" + stockExchangeId + ", board=" + board + ", turnover="
				+ turnover + "]";
	}

	
	
	


}

