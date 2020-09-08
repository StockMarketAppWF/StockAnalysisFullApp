package com.wellsfargo.sectorservice;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.wellsfargo.sectorservice.exceptionHandler.EntityNotFoundException;
import com.wellsfargo.sectorservice.exceptionHandler.GenericException;
import com.wellsfargo.sectorservice.models.Sector;
@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    CompanyRepository companyRepository;

    public Sector createSector(String name, String brief) {
        Sector res;
        try{
            Sector sector = new Sector();
            sector.setSectorName(name);
            sector.setBrief(brief);
            res = sectorRepository.save(sector);
        }
        catch (NullPointerException e){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sectorName", name);
            params.put("brief", brief);
            throw new EntityNotFoundException(Sector.class, params);
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return res;
    }

    public Sector updateSector(String id, String name, String brief) {
        int sectorId;
        Sector res;

        try{
            sectorId = Integer.parseInt(id);
            Sector oldSector = sectorRepository.findOne(sectorId);
            oldSector.setSectorName(name);
            oldSector.setBrief(brief);
            res = sectorRepository.save(oldSector);
        }
        catch (NumberFormatException e){
            throw new HttpMessageNotReadableException("invalid id format");
        }
        catch (NullPointerException e){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sectorId", id);
            throw new EntityNotFoundException(Sector.class, params);
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }


        return res;
    }

    public boolean deleteSector(String id) {
        int sectorId;

        try{
            sectorId = Integer.parseInt(id);
            sectorRepository.deleteById(sectorId);
        }
        catch (NumberFormatException e){
            throw new HttpMessageNotReadableException("invalid id format");
        }
        catch (NullPointerException e){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sectorId", id);
            throw new EntityNotFoundException(Sector.class, params);
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return true;
    }

    public List<Sector> getSectors() {
        return sectorRepository.findAll();
    }

    public Map<String, Object> getCompaniesBySectorId(String id) {
        int sectorId;
        Sector sector;
        Map<String, Object> res = new HashMap<String, Object>();

        try{
            sectorId  = Integer.parseInt(id);
            sector = sectorRepository.findOne(sectorId);
            res.put("sectorId", sector.getSectorId());
            res.put("sectorName", sector.getSectorName());
            res.put("companies", sector.getCompanies());
        }
        catch (NumberFormatException e){
            throw new HttpMessageNotReadableException("invalid id format");
        }
        catch (NullPointerException e){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sectorId", id);
            throw new EntityNotFoundException(Sector.class, params);
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return res;
    }

    public Map<String, Object> sectorCompanyAvgPriceOnAnyExchange(String id, String startDate, String endDate) {
        Map<String, Object> res = new HashMap<String, Object>();

        try{
            int sectorId  = Integer.parseInt(id);
            Date start = Date.valueOf(startDate);
            Date end = Date.valueOf(endDate);

            Sector sector = sectorRepository.findOne(sectorId);

            res.put("sectorId", sector.getSectorId());
            res.put("sectorName", sector.getSectorName());
            res.put("companies", companyRepository.getStockPriceInDateRange(start, end, sectorId));
        }
        catch (NumberFormatException e){
            throw new HttpMessageNotReadableException("invalid id format");
        }
        catch (IllegalArgumentException e){
            throw new HttpMessageNotReadableException("invalid startDate(yyyy-mm-dd), endDate(yyyy-mm-dd) format");
        }
        catch (NullPointerException e){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("sectorId", id);
            throw new EntityNotFoundException(Sector.class, params);
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return res;
    }
}
