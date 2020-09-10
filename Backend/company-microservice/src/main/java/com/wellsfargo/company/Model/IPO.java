package com.wellsfargo.company.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IPO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ipo_id;
	private String num_of_shares;
	private Date open_date;
	private float price_per_share;
	private String remarks;
	private int company_id;

	public IPO() {

	}

	public IPO(int ipo_id, String num_of_shares, Date open_date, float price_per_share, String remarks,
			int company_id) {
		super();
		this.ipo_id = ipo_id;
		this.num_of_shares = num_of_shares;
		this.open_date = open_date;
		this.price_per_share = price_per_share;
		this.remarks = remarks;
		this.company_id = company_id;
	}

	public int getIpo_id() {
		return ipo_id;
	}

	public void setIpo_id(int ipo_id) {
		this.ipo_id = ipo_id;
	}

	public String getNum_of_shares() {
		return num_of_shares;
	}

	public void setNum_of_shares(String num_of_shares) {
		this.num_of_shares = num_of_shares;
	}

	public float getPrice_per_share() {
		return price_per_share;
	}

	public void setPrice_per_share(float price_per_share) {
		this.price_per_share = price_per_share;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

}