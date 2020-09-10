package com.wellsfargo.company.demo;

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

import com.wellsfargo.company.Model.Company;
import com.wellsfargo.company.Repository.CompanyRepository;
import com.wellsfargo.company.Services.CompanyServiceImpl;

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
				.thenReturn(Stream.of(new Company("board", "mark", "facebook", "788", "zing zing amazing", 89))
						.collect(Collectors.toList()));
		List<Company> companylist = companyservice.getCompany();
		assertEquals(1, companyservice.getCompany().size());
	}

//	@Test
//	public void getCompanyByIdtest()
//	{	int cid=28;
//		Company company=new Company("board","mark","facebook","788","zing zing amazing",89);
//		when(companyrepository.findById(cid).get()).thenReturn(company);
//		assertEquals(company,companyservice.getCompanyById(cid));
//	}

	@Test
	public void searchCompanytest() {
		String pattern = "face";
		when(companyrepository.searchCompany(pattern))
				.thenReturn(Stream.of(new Company("board", "mark", "facebook", "788", "zing zing amazing", 89))
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