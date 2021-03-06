
package com.wellsfargo.sector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.wellsfargo.sector.models.Company;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT c.companyName AS companyName, c.companyId AS companyId, AVG(s.price) AS averagePrice " +
            "FROM Company c JOIN c.stockPrices s JOIN c.sector sec " +
            "WHERE s.date BETWEEN ?1 AND ?2 AND sec.sectorId = ?3 GROUP BY c.companyId")
    List<Map<String, Object>> getStockPriceInDateRange(Date startDate, Date endDate, int sectorId);
}
