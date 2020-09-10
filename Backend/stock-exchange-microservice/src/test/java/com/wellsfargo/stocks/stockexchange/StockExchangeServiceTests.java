package com.wellsfargo.stocks.stockexchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stocks.stockexchange.dao.StockExchangeDAO;
import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.entity.StockPrice;
import com.wellsfargo.stocks.stockexchange.repo.ExchangeRepo;
import com.wellsfargo.stocks.stockexchange.service.StockExchangeService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class StockExchangeServiceTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@MockBean
	private ExchangeRepo exchangeRepo;
	
	@Mock
	private ExchangeRepo exchangeDao;
	private Company company1,company2,company3,company4;
	
	@Test
	public void getStockExchangesListTest()
	{
		when(exchangeRepo.findAll()).thenReturn(Stream.of(new Exchange(807,"MockBrief","MockAddress","MockWriteUp")).collect(Collectors.toList()));
		assertEquals(1,stockExchangeService.getStockExchangesList().size());
	}

	@Test
	public void addStockExchangeTest()
	{
		company1 = new Company(12,"MockCompanyName","909","MockCEO","MockBoardOfDirectors","MockWriteUp");
		Exchange exchange = new Exchange(807,"MockBrief","MockAddress","MockWriteUp");
		exchange.getCompany().add(company1);
		company1.getExchange().add(exchange);
		when(exchangeRepo.save(exchange)).thenReturn(exchange);
		assertEquals(exchange,stockExchangeService.addStockExchange(exchange));
	}
	
	@Test
	public void getCompaniesListTest()
	{
		int id = 132;
		company1 = new Company(12,"MockCompanyName_12","909","MockCEO_12","MockBoardOfDirectors_12","MockWriteUp_12");
		company2 = new Company(15,"MockCompanyName_15","909","MockCEO_15","MockBoardOfDirectors_15","MockWriteUp_15");
		
		company3 = new Company(41,"MockCompanyName_41","909","MockCEO_41","MockBoardOfDirectors_41","MockWriteUp_41");
		company4 = new Company(45,"MockCompanyName_45","909","MockCEO_45","MockBoardOfDirectors_45","MockWriteUp_45");
		List<Company> companieslist1 = new ArrayList<Company>();
		companieslist1.add(company1);
		companieslist1.add(company2);
		
		List<Company> companieslist2 = new ArrayList<Company>();
		companieslist2.add(company3);
		companieslist2.add(company4);
		
		Exchange exchange1 = new Exchange(132,"MockBriefChange_132","MockAddresschange_132","MockWriteUpchange_132");
		Exchange exchange2 = new Exchange(150,"MockBrief_150","MockAddress_150","MockWriteUp_150");
		exchange1.getCompany().add(company1);
		company1.getExchange().add(exchange1);
		
		exchange1.getCompany().add(company2);
		company2.getExchange().add(exchange1);
		
		exchange2.getCompany().add(company3);
		company3.getExchange().add(exchange2);
		
		exchange2.getCompany().add(company4);
		company4.getExchange().add(exchange2);

		when(exchangeRepo.findAll()).thenReturn(Stream.of(exchange1).collect(Collectors.toList()));
		
		List<Exchange> returnedExchange = stockExchangeService.getStockExchangesList();
		int size=0;

		for (Exchange exchange : returnedExchange)
		{
			if(exchange.getExchangeId() == id)
			{
				size = exchange.getCompany().size();
				break;
			}
		}
		exchange1 = exchangeDao.save(exchange1);
		assertEquals(2,size);
	}
	
}
