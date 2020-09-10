package com.wellsfargo.stocks.stockexchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.stocks.stockexchange.controller.StockExchangeController;
import com.wellsfargo.stocks.stockexchange.dao.StockExchangeDAO;
import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.entity.StockPrice;
import com.wellsfargo.stocks.stockexchange.repo.ExchangeRepo;
import com.wellsfargo.stocks.stockexchange.service.StockExchangeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockexchangeApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ExchangeRepo exchangeRepo;
	
	ObjectMapper om = new ObjectMapper();

	@Test
	public void addStockExchangeTest() throws Exception{
		Exchange exchange = new Exchange(807,"MockBrief","MockAddress","MockWriteUp");

		String jsonRequest = om.writeValueAsString(exchange);
		MvcResult result = mockMvc.perform(post("/stockexchange/addstockexchange")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Exchange resultExchange = om.readValue(resultContent,Exchange.class);
		Assert.assertEquals(resultExchange.getExchangeId(), exchange.getExchangeId());
	}
	
	@Test
	public void getStockExchangesListTest() throws Exception{
		MvcResult result = mockMvc.perform(get("/stockexchange/getstockexchangelist"))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		List<Exchange> resultExchange = om.readValue(resultContent, new TypeReference<List<Exchange>>(){});
		Assert.assertEquals(resultExchange.size(),exchangeRepo.findAll().size());
	}
	
	@Test
	public void getCompaniesListTest() throws Exception{
		MvcResult result = mockMvc.perform(get("/stockexchange/getcompanylist/984"))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		List<Company> resultExchange = om.readValue(resultContent, new TypeReference<List<Company>>(){});
		Assert.assertEquals(resultExchange.size(),exchangeRepo.findById(984).getCompany().size());
	}
	
	
	@Test
	public void contextLoads() {
	}
	
	
	
}