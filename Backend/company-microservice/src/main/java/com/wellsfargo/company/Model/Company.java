package com.wellsfargo.company.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int company_id;
	private String board_of_directors;
	private String ceo;

	private String company_name;
	private String turnover;

	private String write_up;
	private int sector_id;

	public Company(String board_of_directors, String ceo, String company_name, String turnover, String write_up,
			int sector_id) {

		this.board_of_directors = board_of_directors;
		this.ceo = ceo;
		this.company_name = company_name;
		this.turnover = turnover;
		this.write_up = write_up;
		this.sector_id = sector_id;
	}

	public Company() {

	}

	public int getCompany_id() {
		return company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoard_of_directors() {
		return board_of_directors;
	}

	public void setBoard_of_directors(String board_of_directors) {
		this.board_of_directors = board_of_directors;
	}

	public int getSector_id() {
		return sector_id;
	}

	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}

	public String getWrite_up() {
		return write_up;
	}

	public void setWrite_up(String write_up) {
		this.write_up = write_up;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

}