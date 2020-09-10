package com.wellsfargo.company.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import com.wellsfargo.company.Model.Company;
import com.wellsfargo.company.Model.IPO;

import java.sql.Date;
import java.util.List;
import com.wellsfargo.company.Repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService
{
	@Autowired CompanyRepository companyrepository;
	
	@Override
    public List<Company> getCompany()
    {
    	List<Company> results = companyrepository.findAll();
		return results;
    }
	
	@Override
	public List<Company> searchCompany(String pattern)
	{

		List<Company> results = companyrepository.searchCompany(pattern);
		return results;
		
	}
	
	@Override
    public void createCompany(String company_name, String turnover, String ceo, String board_of_directors, String write_up, String sector_id) 
    {
         
          
          int s_id= Integer.parseInt(sector_id);

          Company c = new Company();
     	  c.setCompany_name(company_name);
			c.setTurnover(turnover);
			c.setCeo(ceo);
			c.setBoard_of_directors(board_of_directors);
			c.setWrite_up(write_up);
			c.setSector_id(s_id);
          
	       companyrepository.save(c);

    }
	
	@Override
    public Company updateCompany(int company_id,String company_name, String turnover, String ceo, String board_of_directors, String write_up, String sector_id)
    {
//    	int id=Integer.parseInt(ipo_id);
		int s_id= Integer.parseInt(sector_id);
    	Company c = companyrepository.getOne(company_id);
    	c.setCompany_name(company_name);
		c.setTurnover(turnover);
		c.setCeo(ceo);
		c.setBoard_of_directors(board_of_directors);
		c.setWrite_up(write_up);
		c.setSector_id(s_id);        	        
        return companyrepository.save(c);
    }
	@Override
	 public Company getCompanyById(Integer id) {
	        return companyrepository.findBycompanyId(id);
	    }
	@Override
	 public void deleteCompany(Integer id) {
        companyrepository.deleteById(id);
    }
}