package com.wellsfargo.stockexchange.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockexchange.Model.StockPrice;
import com.wellsfargo.stockexchange.Repository.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService{
	@Autowired StockPriceRepository stockpricerepository;
	
	@Override
	public List<StockPrice> getStockprice(int company_id,Date fromdate, Date todate,int exchange_id)
	{
		List<StockPrice> results=stockpricerepository.getStockPrice(company_id, fromdate, todate, exchange_id);
		return results;
	}
	
	

}
