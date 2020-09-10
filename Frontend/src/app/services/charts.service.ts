import { ChartDetails } from './../models/charts';
import { CompanyPriceDetails } from './../models/sector-compare-data';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChartsService {

  constructor() { }
  showChartService(companyPriceData,chartType){
    console.log(companyPriceData);
    let chartDetails : ChartDetails = new ChartDetails();
    chartDetails.chartType = chartType;

    for(const company of companyPriceData)
    {
      chartDetails.chartLabels.push(company.companyName);
      chartDetails.avgPrice.push(company.averagePrice);
      chartDetails.minPrice.push(company.minPrice);
      chartDetails.maxPrice.push(company.maxPrice);
      chartDetails.palette.push(this.backgroundColor());
    }
    return chartDetails;
  }
  backgroundColor(){
    return 'rgb('
       + Math.round(Math.random() *255) + ','
       + Math.round(Math.random() *255) + ','
       + Math.round(Math.random() *255)
       + ')';
 }
}
