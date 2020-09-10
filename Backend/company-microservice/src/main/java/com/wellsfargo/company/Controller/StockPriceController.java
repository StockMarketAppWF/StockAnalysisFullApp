package com.wellsfargo.company.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.company.Model.StockPrice;
import com.wellsfargo.company.Services.StockPriceService;

@CrossOrigin(origins = "*")
@RestController
public class StockPriceController {
	
	@Autowired StockPriceService stockpriceservice;
	
	@GetMapping("/getstockprice/{cid}/{fdate}/{tdate}/{exchange_id}")
	public List<StockPrice> getstockprice(@PathVariable int cid,@PathVariable String fdate,@PathVariable String tdate,@PathVariable int exchange_id)
	{
		Date fromdate=Date.valueOf(fdate);
		Date todate=Date.valueOf(tdate);
		return stockpriceservice.getStockprice(cid, fromdate, todate,exchange_id);
	}

}
