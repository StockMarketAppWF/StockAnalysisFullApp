package com.wellsfargo.stockexchange.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.stockexchange.Model.IPO;

public interface IPORepository extends JpaRepository<IPO, Integer>
{

	@Query("select d from IPO d WHERE d.company_id= ?1 ORDER BY d.open_date")
	List<IPO> searchIpo(int  id);
	
	@Query("select d from IPO d ORDER BY d.open_date")
	List<IPO> findAllIpo();

}