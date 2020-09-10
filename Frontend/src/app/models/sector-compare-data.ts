export class SectorCompare {
    sectorId : number;
    sectorName : string;
    brief : string;
    noOfCompanies: number;
    highestAvg;
    highestHigh;
    lowestLow;
    companiesPrice;
    companyPriceDetails : CompanyPriceDetails[];
}

export class CompanyPriceDetails{
    companyId : number;
    companyName : string;
    minPrice : number;
    averagePrice : number;
    maxPrice : number;
}
