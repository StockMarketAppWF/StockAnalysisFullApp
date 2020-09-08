package com.wellsfargo.stockexchange.market;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.stockexchange.market.entity.Company;
import com.wellsfargo.stockexchange.market.entity.Exchange;
import com.wellsfargo.stockexchange.market.repo.ExchangeRepo;

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

	public WebApplicationContext getContext() {
		return context;
	}

	public void setContext(WebApplicationContext context) {
		this.context = context;
	}
	
	
	
}