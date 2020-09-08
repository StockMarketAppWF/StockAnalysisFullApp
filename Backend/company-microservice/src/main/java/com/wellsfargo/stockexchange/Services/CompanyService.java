package com.wellsfargo.stockexchange.Services;

import java.util.List;

import com.wellsfargo.stockexchange.Model.Company;

public interface CompanyService {
	public abstract List<Company> searchCompany(String pattern);
	public abstract void createCompany(String company_name, String turnover, String ceo, String board_of_directors, String write_up, String sector_id);
	public abstract Company updateCompany(int company_id,String company_name, String turnover, String ceo, String board_of_directors, String write_up, String sector_id);
	public abstract Company getCompanyById(Integer id);
	public abstract void deleteCompany(Integer id);
	public abstract List<Company> getCompany();
	

}
