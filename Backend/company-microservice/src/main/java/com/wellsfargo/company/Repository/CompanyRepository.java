package com.wellsfargo.company.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellsfargo.company.Model.Company;



public interface CompanyRepository extends JpaRepository<Company, Integer>
{

	@Query("SELECT c FROM Company c WHERE c.company_name LIKE %?1%")
	List<Company> searchCompany(String pattern);
	@Query("SELECT c from Company c WHERE c.company_id=?1")
	Company findBycompanyId(Integer id);
	
	

}