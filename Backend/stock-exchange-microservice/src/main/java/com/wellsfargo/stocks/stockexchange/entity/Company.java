package com.wellsfargo.stocks.stockexchange.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @Column(name = "company_id")
    private int companyId;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String turnover;
    @Column(nullable = false)
    private String ceo;
    private String boardOfDirectors;
    @Column(nullable = false)
    private String writeUp;
    @OneToOne(mappedBy = "company")
    private IPO ipo;
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<StockPrice> stockPrices;
  
    
    public Company() {
		super();
	}

	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "company")
    @JsonIgnore

    private List<Exchange> exchange = new ArrayList<Exchange>();
    
    @ManyToMany(fetch = FetchType.LAZY,
    	    cascade = {
    	        CascadeType.PERSIST,
    	        CascadeType.MERGE
    	    },
    	    mappedBy = "company")
    	    private List<Sector> sector = new ArrayList<>();
    	    
	public Company(int companyId, String companyName, String turnover, String ceo, String boardOfDirectors,
			String writeUp) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.writeUp = writeUp;
	}

	public List<Exchange> getExchange() {
		return exchange;
	}

	public void setExchange(List<Exchange> exchange) {
		this.exchange = exchange;
	}

	public void setSector(List<Sector> sector) {
		this.sector = sector;
	}


	public List<StockPrice> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(List<StockPrice> stockPrices) {
        this.stockPrices = stockPrices;
    }


    public IPO getIpo() {
        return ipo;
    }

    public void setIpo(IPO ipo) {
        this.ipo = ipo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(String boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public String getWriteUp() {
        return writeUp;
    }

    public void setWriteUp(String writeUp) {
        this.writeUp = writeUp;
    }
}
