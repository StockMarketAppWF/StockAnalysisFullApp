import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ExchangeService } from "../../services/exchange.service";
import { DetailService } from "../../services/detail.service";
import { NgbDropdown } from "@ng-bootstrap/ng-bootstrap";
import { ViewChild } from "@angular/core";
import { Exchange } from "../../exchange";
import { Company } from "../../company";
import { HttpClient } from "@angular/common/http";

import { EditExchangeService } from "../../services/edit-exchange.service";
import { CompanyListService } from "../../services/company-list.service";

@Component({
  selector: "app-exchange-details",
  templateUrl: "./exchange-details.component.html",
  styleUrls: ["./exchange-details.component.css"],
})
export class ExchangeDetailsComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _exchangeService: ExchangeService,
    private _detailService: DetailService,
    private httpClient: HttpClient,
    private _editExchangeService: EditExchangeService,
    private _companyListService: CompanyListService
  ) {}
  item: Exchange;
  selectedId: number;
  name: string;
  index: number;
  newCompaniesList: Company[];
  deleteCompany: Company;
  flag: number = 0;
  url = "http://localhost:3795/stockexchange/addstockexchange";
  companies: Company[] = [
    {
      companyId: 14,
      boardOfDirectors: "Board",
      ceo: "CEO2",
      companyName: "Company_DEF",
      turnover: "123",
      writeUp: "WriteUp",
    },
    {
      companyId: 1,
      boardOfDirectors: "abc",
      ceo: "bcd",
      companyName: "Company_abc",
      turnover: "1234",
      writeUp: "writeup",
    },
    {
      companyId: 111,
      boardOfDirectors: "Board_111",
      ceo: "CEO3",
      companyName: "Company_GHI",
      turnover: "12345",
      writeUp: "WriteUp1",
    },
  ];
  public params2: URLSearchParams = new URLSearchParams();
  newCompany: any = {};
  currentCompany: any = {};
  ngOnInit(): void {
    this._detailService.share.subscribe((x) => (this.item = x));
    localStorage.setItem("itemlist", JSON.stringify(this.item));
    this.selectedId = this.item.exchangeId;
    this.newCompaniesList = this.item.company;
  }
  changeLabelName(lbl, companyname, currentCompany) {
    document.getElementById(lbl).innerHTML = companyname;
    this.currentCompany = currentCompany;
  }

  addCompany() {
    if (this.currentCompany != null) {
      for (let value of this.newCompaniesList) {
        if (this.currentCompany == value) {
          this.flag = 1;
          break;
        }
      }

      if (this.flag == 0) {
        this.newCompaniesList.push(this.currentCompany);
      }
    }

    console.log(this.currentCompany);
  }

  removeCompany(index) {
    this.newCompaniesList.splice(index, 1);
  }

  editExchange() {
    this.item.address = (<HTMLInputElement>(
      document.getElementById("newAddress")
    )).value;
    this.item.brief = (<HTMLInputElement>(
      document.getElementById("newBrief")
    )).value;
    this.item.remarks = (<HTMLInputElement>(
      document.getElementById("newRemarks")
    )).value;

    this._editExchangeService
      .sendExchangeData(JSON.stringify(this.item))
      .toPromise()
      .then((response) => {
        console.log("Inside promise", response);
      })
      .then(() => {
        this.router.navigate(["/success/details", this.item.exchangeId]);
      });
    // console.log('hererereree', this.newExchange2);
  }
}
