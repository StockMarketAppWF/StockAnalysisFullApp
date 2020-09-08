package com.wellsfargo.stockexchange.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stockexchange.Model.StockPrice;
import com.wellsfargo.stockexchange.Repository.StockPriceRepository;
import com.wellsfargo.stockexchange.Services.StockPriceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockPriceServiceTests {
	@Autowired
	private StockPriceServiceImpl stockpriceservice;
	@MockBean
	private StockPriceRepository stockpricerepository;

	@Test
	public void getStockpricewhenRecordSatisfyingConditionExistTest() {
		int company_id=5;
		String fdate="2020-02-01";
		String tdate="2020-02-30";
		Date fromdate=Date.valueOf(fdate);
		Date todate=Date.valueOf(tdate);
		int exchange_id=2;
		
		when(stockpricerepository.getStockPrice(company_id, fromdate, todate,exchange_id)).thenReturn(Stream
				.of(new StockPrice(1, 355, Date.valueOf("2020-02-15"),Time.valueOf("22:37:32"), 1, 2)).collect(Collectors.toList()));

		List <StockPrice> stockpricelist=stockpriceservice.getStockprice(company_id, fromdate, todate,exchange_id);
		assertEquals(stockpricelist.get(0).getStockId(), 1);
		
		
	}
	
	
}
