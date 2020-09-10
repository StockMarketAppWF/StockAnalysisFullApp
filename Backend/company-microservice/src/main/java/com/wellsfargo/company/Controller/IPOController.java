package com.wellsfargo.company.Controller;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.company.Model.IPO;
import com.wellsfargo.company.Services.IPOServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class IPOController 
{
	@Autowired
	IPOServiceImpl iposervice;
	
	@GetMapping("/getipo")
    public List<IPO> getIpo()
    {
       return iposervice.getIpo();
    }
	
	

	 @GetMapping("/getipobyid/{id}")
	    public List<IPO> getIpoById(@PathVariable int id)
	    {
	        return iposervice.getIpo(id);
	    }
	 
	 
	 @PutMapping("/updateipo/{id}")
	    public IPO updateIpo(@PathVariable int id,  @RequestBody Map<String, String> body)
	    {
		//String s=body.get("ipo_id");
		String num_of_shares=body.get("num_of_shares");
		String Dd=body.get("open_date");
	    String pps = body.get("price_per_share");
		Float price_per_share=Float.parseFloat(pps);
	    String remarks = body.get("remarks");
	    String companyid=body.get("company_id");
	    int company_id=Integer.parseInt(companyid);

	    return iposervice.updateIpo(id,num_of_shares,Dd,price_per_share,remarks,company_id);
	    }
	 
	 @PostMapping("/insertipo")
	    public IPO createIpo(@RequestBody Map<String, String> body)
	    {
	    	//String id = body.get("ipo_id");
			//int ipo_id=Integer.parseInt(id);
			String num_of_shares = body.get("num_of_shares");
			String D = body.get("open_date");
			Date open_date=Date.valueOf(D);
			String price_per_share = body.get("price_per_share");
			Float pps=Float.parseFloat(price_per_share);
			String remarks= body.get("remarks");
			String company_id = body.get("company_id");
			int c_id=Integer.parseInt(company_id);
	        return iposervice.createIpo(num_of_shares,open_date,pps,remarks,c_id);
	    }
	 @DeleteMapping("/deleteipo/{id}")
		public void deleteIpo(@PathVariable Integer id){

			iposervice.deleteIpo(id);
		}
	 

	
}


