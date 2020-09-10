package com.wellsfargo.company.Services;

import java.sql.Date;
import java.util.List;

import com.wellsfargo.company.Model.IPO;


public interface IPOService {

   public abstract IPO updateIpo(int ipo_id,String num_of_shares,String D,Float price_per_share,String remarks,int company_id);
    public abstract List<IPO> getIpo(int id);
    public abstract List<IPO> getIpo();
    public abstract IPO createIpo(String num_of_shares,Date D,Float price_per_share,String remarks,int company_id);
    public abstract void deleteIpo(Integer id);
}