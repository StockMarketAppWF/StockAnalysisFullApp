import { Component, OnInit } from "@angular/core";
import { Exchange } from "../../exchange";
import { Company } from "../../company";
import { ExchangeService } from "../../services/exchange.service";
import { Router } from "@angular/router";
// import { FormsModule } from '@angular/forms';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-add-stock-exchange",
  templateUrl: "./add-stock-exchange.component.html",
  styleUrls: ["./add-stock-exchange.component.css"],
})
export class AddStockExchangeComponent implements OnInit {
  constructor(private httpClient: HttpClient, private router: Router) {} // public remarks: string // public brief: string, // public address: string, // public ,
  url = "http://localhost:3795/stockexchange/addstockexchange";
  newExchange: Exchange = {
    exchangeId: 0,
    address: "",
    brief: "",
    remarks: "",
    company: [] as Company[],
  };
  ngOnInit(): void {}

  addExchange() {
    this.newExchange.exchangeId = parseInt(
      (<HTMLInputElement>document.getElementById("exchangeId")).value
    );
    this.newExchange.brief = (<HTMLInputElement>(
      document.getElementById("brief")
    )).value;
    this.newExchange.address = (<HTMLInputElement>(
      document.getElementById("address")
    )).value;
    this.newExchange.remarks = (<HTMLInputElement>(
      document.getElementById("remarks")
    )).value;
    console.log(this.newExchange);
    this.httpClient
      .post(this.url, this.newExchange)
      .toPromise()
      .then((data) => console.log(data))
      .then(() => this.router.navigate(["/success/exchange"]));
  }
}
