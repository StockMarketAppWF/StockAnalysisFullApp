package com.wellsfargo.stockexchange.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockexchange.stock.entity.StockExchange;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {

}
