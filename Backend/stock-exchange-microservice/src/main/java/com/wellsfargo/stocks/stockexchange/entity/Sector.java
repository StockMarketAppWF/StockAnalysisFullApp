package com.wellsfargo.stocks.stockexchange.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sector implements Serializable{
    @Id
    @Column(name = "sector_id")
    private int sectorId;
    @Column(nullable = false)
    private String sectorName;
    private String brief;
   
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "company_sectors",
            joinColumns = { @JoinColumn(name = "sector_id") },
            inverseJoinColumns = { @JoinColumn(name = "company_id") })
    
    
    private List<Company> company = new ArrayList<Company>();
    
    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

}
