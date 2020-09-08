import { Component, OnInit } from '@angular/core';
import { Sector } from '../../models/sector-data';
import { ChartDetails } from './../../models/charts';
import { SectorCompare, CompanyPriceDetails } from '../../models/sector-compare-data';
import { SectorService } from '../../services/sector.service';
import { ChartsService } from './../../services/charts.service';
import Utils from '../../helpers/utils';
import { Observable, range } from 'rxjs';
import Chart from 'chart.js';
import { Company } from '../../models/company-data';

@Component({
  selector: 'app-sector',
  templateUrl: './sector.component.html',
  styleUrls: ['./sector.component.css']
})
export class SectorComponent implements OnInit {

  backgroundColor(){
    return 'rgb('
       + Math.round(Math.random() *255) + ','
       + Math.round(Math.random() *255) + ','
       + Math.round(Math.random() *255)
       + ')';
  }
  ngOnInit(): void {
  }

  compareSector1;
  compareSector2;
  sectors : Sector[] = [];
  
  companies : Company[] = [];

  selectedSector: Sector = new Sector();
  startDate: Date = new Date();
  endDate;
  startDate2;
  endDate2;
  showGraph: boolean = false;
  showPie: boolean = true;
  

  sectorNameForPie;
  chartType;

  compareSectorData1: SectorCompare = new SectorCompare();
  compareSectorData2: SectorCompare = new SectorCompare();
  compareSectorData: SectorCompare = new SectorCompare();

    barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  barChartType = 'bar';
  barChartLegend = true;

  avgChartLabels = ['Highest Average'];
  highChartLabels = ['Highest High'];
    lowChartLabels = ['Lowest Low'];

    avgChartData = [];
    highChartData = [];
    lowChartData = [];

  constructor(private sectorService: SectorService ) {
    sectorService.fetchSectors().subscribe(data => {
      this.sectors = data as Sector[];
    });
  }
  
  handleCompareSector() {
    const id1 = this.compareSector1;
    const id2 = this.compareSector2;
    this.fetchSectorCompare(id1, id2, this.startDate, this.endDate);
  }
  selectSector(id) {
    this.sectorService.fetchSectorCompanies(id).subscribe(data => {
      this.companies = data.companies as Company[];
      this.selectedSector.id = data.id;
      this.selectedSector.sector = data.sector;
      this.selectedSector.description = data.description;
    });
  }
  fetchSectorCompare(id1, id2, startDate, endDate) {
    const sDate = Utils.convertDate(startDate);
    const eDate = Utils.convertDate(endDate);
    this.avgChartData = [];
    this.highChartData = [];
    this.lowChartData = [];
    this.sectorService.fetchSectorWithPrices(id1, sDate, eDate).subscribe(data => {
      this.compareSectorData1.id = data.id;
      this.compareSectorData1.sector = data.sector;
      this.compareSectorData1.description = data.description;
      this.compareSectorData1.noOfCompanies = data.noOfCompanies;
      this.compareSectorData1.highestAvg = data.highestAvg;
      this.compareSectorData1.highestHigh = data.highestHigh;
      this.compareSectorData1.lowestLow = data.lowestLow;
      var avgChart = {
        data: [data.highestAvg.stockPrice],
        label: "Sector 1 -" + data.highestAvg.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.avgChartData.push(avgChart);
      var highChart = {
        data: [data.highestHigh.stockPrice],
        label: "Sector 1 - " + data.highestHigh.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.highChartData.push(highChart);
      var lowChart = {
        data: [data.lowestLow.stockPrice],
        label: "Sector 1 - " + data.lowestLow.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.lowChartData.push(lowChart);
      this.showGraph = true;
    });
    this.sectorService.fetchSectorWithPrices(id2, sDate, eDate).subscribe(data => {
      this.compareSectorData2.id = data.id;
      this.compareSectorData2.sector= data.sector;
      this.compareSectorData2.description = data.description;
      this.compareSectorData2.noOfCompanies = data.noOfCompanies;
      this.compareSectorData2.highestAvg = data.highestAvg;
      this.compareSectorData2.highestHigh = data.highestHigh;
      this.compareSectorData2.lowestLow = data.lowestLow;
      var avgChart = {
        data: [data.highestAvg.stockPrice],
        label: "Sector 2 - " + data.highestAvg.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.avgChartData.push(avgChart);

      var highChart = {
        data: [data.highestHigh.stockPrice],
        label: "Sector 2 - " + data.highestHigh.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.highChartData.push(highChart);
      let lowChart = {
        data: [data.highestHigh.stockPrice],
        label: "Sector 2 - " + data.highestHigh.companyName,
        backgroundColor: this.backgroundColor()
      }
      this.lowChartData.push(lowChart);
      this.showGraph = true;
    });
  }

  myChart1;myChart2;myChart3;
  chartDetails: ChartDetails;
  chartsService: ChartsService = new ChartsService();

  handleCompareCompanyBySector(){
    this.sectorService.fetchSectorWithPrices(this.sectorNameForPie,Utils.convertDate(this.startDate2), Utils.convertDate(this.endDate2)).subscribe(data => {
      this.compareSectorData.companyPriceDetails = data.companies as CompanyPriceDetails[];
      console.log(this.compareSectorData.companyPriceDetails);
    if(this.myChart1)
      {        this.myChart1.destroy();this.myChart2.destroy();this.myChart3.destroy();}
    this.chartDetails = this.chartsService.showChartService(this.compareSectorData.companyPriceDetails,this.chartType);
    console.log(this.chartDetails);
    var canvas = <HTMLCanvasElement> document.getElementById('compare-company1');
    if (canvas.getContext) {
      var ctx = canvas.getContext('2d');
      this.myChart1 = new Chart(ctx, {
        type: this.chartDetails.chartType,
        data: {
            labels: this.chartDetails.chartLabels,
            datasets: [{
              label : 'Stock Average Price Comparison',
                backgroundColor: this.chartDetails.palette,
                data: this.chartDetails.avgPrice
            }]
        },
        options: {}
    });
    }
    var canvas = <HTMLCanvasElement> document.getElementById('compare-company2');
    if (canvas.getContext) {
      var ctx = canvas.getContext('2d');
      this.myChart2 = new Chart(ctx, {
        type: this.chartDetails.chartType,
        data: {
            labels: this.chartDetails.chartLabels,
            datasets: [{
              label : 'Stock Maximum Price Comparison',
                backgroundColor: this.chartDetails.palette,
                data: this.chartDetails.maxPrice
            }]
        },
        options: {}
    });
    }

    var canvas = <HTMLCanvasElement> document.getElementById('compare-company3');
    if (canvas.getContext) {
      var ctx = canvas.getContext('2d');
      this.myChart3 = new Chart(ctx, {
        type: this.chartDetails.chartType,
        data: {
            labels: this.chartDetails.chartLabels,
            datasets: [{
              label : 'Stock Minimum Price Comparison',
                backgroundColor: this.chartDetails.palette,
                data: this.chartDetails.minPrice
            }]
        },
        options: {}
      });
    }
  });
  }
  onStartDateChange(event) {
    var date = new Date(event.value);
    this.startDate = date;
    this.startDate2 = date;
  }
  onEndDateChange(event) {
    var date = new Date(event.value);
    this.endDate = date;
    this.endDate2 = date;
  }
}
