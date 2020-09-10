package com.wellsfargo.stocks.stockexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stocks.stockexchange.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
