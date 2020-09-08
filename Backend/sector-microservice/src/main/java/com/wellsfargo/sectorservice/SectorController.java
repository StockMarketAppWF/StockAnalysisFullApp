package com.wellsfargo.sectorservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sectorservice.exceptionHandler.EntityNotFoundException;
import com.wellsfargo.sectorservice.exceptionHandler.GenericException;
import com.wellsfargo.sectorservice.exceptionHandler.MissingParamsException;
import com.wellsfargo.sectorservice.models.Sector;

@RestController
public class SectorController {
    @Autowired
    SectorService sectorService;

    @PostMapping("/sector")
    public Sector createSector(@RequestBody Map<String, String> body){
        String sectorName = body.get("name");
        String sectorBrief = body.get("brief");

        return sectorService.createSector(sectorName, sectorBrief);
    }

    @PutMapping("/sector/{id}")
    public Sector updateSector(@PathVariable String id,  @RequestBody Map<String, String> body){
        String sectorName;
        String sectorBrief;
        try{
            sectorName = body.get("name");
            sectorBrief = body.get("brief");
        }
        catch (NullPointerException e){
            throw new MissingParamsException("missing request params");
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return sectorService.updateSector(id, sectorName, sectorBrief);
    }

    @DeleteMapping("/sector/{id}")
    public boolean deleteSector(@PathVariable String id) throws EntityNotFoundException {

        return sectorService.deleteSector(id);
    }

    @GetMapping("/sectors")
    public List<Sector> sectors(){
        return sectorService.getSectors();
    }

    @GetMapping("/sector/{id}")
    public Map<String, Object> sectorCompanies(@PathVariable String id) throws EntityNotFoundException {
        return sectorService.getCompaniesBySectorId(id);
    }

    @PostMapping("/sector/price/{id}")
    public Map<String, Object> sectorPrices(@PathVariable String id, @RequestBody Map<String, Object> body){
        String startDate;
        String endDate;

        try{
            startDate = body.get("startDate").toString();
            endDate = body.get("endDate").toString();
        }
        catch (NullPointerException e){
            throw new MissingParamsException("missing request params");
        }
        catch (Exception e){
            System.out.println(e.toString());
            throw new GenericException(e);
        }

        return sectorService.sectorCompanyAvgPriceOnAnyExchange(id, startDate, endDate);
    }
}