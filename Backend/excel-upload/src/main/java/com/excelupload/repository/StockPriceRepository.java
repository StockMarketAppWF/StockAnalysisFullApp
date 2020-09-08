package com.excelupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelupload.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice,Integer> {

}
