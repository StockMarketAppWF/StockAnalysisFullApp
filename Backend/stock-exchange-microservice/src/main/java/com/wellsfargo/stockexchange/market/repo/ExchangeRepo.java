package com.wellsfargo.stockexchange.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockexchange.market.entity.Exchange;

@Repository
public interface ExchangeRepo extends JpaRepository<Exchange, Integer> {
	public Exchange findById(int id);
}
