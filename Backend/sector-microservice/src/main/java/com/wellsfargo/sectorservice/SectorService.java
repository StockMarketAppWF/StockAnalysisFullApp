package com.wellsfargo.sectorservice;
import java.util.*;

import com.wellsfargo.sectorservice.models.Sector;
public interface SectorService {
    Sector createSector(String name, String brief);
    Sector updateSector(String id, String name, String brief);
    boolean deleteSector(String id);
    List<Sector> getSectors();
    Map<String, Object> getCompaniesBySectorId(String id);
    Map<String, Object> sectorCompanyAvgPriceOnAnyExchange(String id, String startDate, String endDate);
}
