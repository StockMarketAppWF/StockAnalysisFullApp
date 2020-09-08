package com.wellsfargo.stockexchange.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stockexchange.Model.Company;
import com.wellsfargo.stockexchange.Repository.CompanyRepository;
import com.wellsfargo.stockexchange.Services.CompanyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
	@Autowired
	private CompanyServiceImpl companyservice;
	@MockBean
	private CompanyRepository companyrepository;

	@Test
	public void getCompanywhenRecordSatisfyingConditionExistTest() {
		when(companyrepository.findAll())
				.thenReturn(Stream.of(new Company("board", "ambani", "jio", "001", "made in india", 89))
						.collect(Collectors.toList()));
		List<Company> companylist = companyservice.getCompany();
		assertEquals(1, companyservice.getCompany().size());
	}


	@Test
	public void searchCompanytest() {
		String pattern = "face";
		when(companyrepository.searchCompany(pattern))
				.thenReturn(Stream.of(new Company("board", "ambani", "jio", "001", "made in india", 89))
						.collect(Collectors.toList()));
		List<Company> companylist = companyservice.searchCompany(pattern);
		assertEquals(1, companyservice.searchCompany(pattern).size());
	}

	@Test
	public void deleteCompanyTest() {
		int cid = 28;
		companyservice.deleteCompany(cid);
		verify(companyrepository, times(1)).deleteById(cid);
	}
}