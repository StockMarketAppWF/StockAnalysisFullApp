package com.wellsfargo.stockexchange.Services;

import java.sql.Date;
import java.util.List;

import com.wellsfargo.stockexchange.Model.StockPrice;

public interface StockPriceService {
	public abstract List<StockPrice> getStockprice(int company_id,Date fromdate, Date todate,int exchange_id);

}
