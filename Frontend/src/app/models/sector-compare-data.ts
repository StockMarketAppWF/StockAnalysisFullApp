export class SectorCompare {
    id : number;
    sector : string;
    description : string;
    noOfCompanies: number;
    highestAvg;
    highestHigh;
    lowestLow;
    companiesPrice;
    companyPriceDetails : CompanyPriceDetails[];
}
export class CompanyPriceDetails{
    cid : string;
    company : string;
    minPrice : number;
    averagePrice : number;
    maxPrice : number;
}
