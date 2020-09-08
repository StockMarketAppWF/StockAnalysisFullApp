package com.wellsfargo.stockexchange.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockexchange.market.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
