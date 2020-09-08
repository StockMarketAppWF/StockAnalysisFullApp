package com.wellsfargo.stockexchange.stock.entity;
import javax.persistence.*;

@Entity
@Table(name="stockExchange")
public class StockExchange {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="brief")
	private String brief;
	
	@Column(name="contact_address")
	private String contactAddress;
	
	@Column(name="remarks")
	private String remarks;
	
	StockExchange(){}

	public StockExchange(int id, String name, String brief, String contactAddress, String remarks) {
		super();
		this.id = id;
		this.name = name;
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
		return "StockExchange [id=" + id + ", name=" + name + ", brief=" + brief + ", contactAddress=" + contactAddress
				+ ", remarks=" + remarks + "]";
	}

	

}
