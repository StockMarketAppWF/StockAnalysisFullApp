package com.wellsfargo.company.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.company.Model.IPO;
import com.wellsfargo.company.Repository.IPORepository;
import com.wellsfargo.company.Services.IPOServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class IPOServiceTest{
	@Autowired
	private IPOServiceImpl iposervice;
	@MockBean
	private IPORepository iporepository;

	@Test
	public void getIPOwhenRecordSatisfyingConditionExistTest() {
		when(iporepository.findAll()).thenReturn(Stream
				.of(new IPO(1,"one", Date.valueOf("2020-02-15"),4.2f, "nil", 2)).collect(Collectors.toList()));
		List <IPO> ipolist=iposervice.getIpo();
		assertEquals(ipolist.get(0).getIpo_id(), 1);		
	}
	
	
	
}