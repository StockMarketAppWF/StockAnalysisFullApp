package com.wellsfargo.stocks.stockexchange.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;

public interface ExchangeRepo extends JpaRepository<Exchange, Integer> {
	public Exchange findById(int id);
}
