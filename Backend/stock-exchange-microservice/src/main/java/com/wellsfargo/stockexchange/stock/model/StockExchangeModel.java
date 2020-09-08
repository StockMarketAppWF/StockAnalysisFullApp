package com.wellsfargo.stockexchange.stock.model;

public class StockExchangeModel {


	private int id;
	
	private String name;
	
	private String brief;
	
	private String contactAddress;

	private String remarks;
	
	StockExchangeModel(){}

	public StockExchangeModel(int id, String name ,String brief, String contactAddress, String remarks) {
		super();
		this.id = id;
		this.name=name;
		this.brief = brief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StockExchangeModel [id=" + id + ", name=" + name + ", brief=" + brief + ", contactAddress="
				+ contactAddress + ", remarks=" + remarks + "]";
	}

	

}
