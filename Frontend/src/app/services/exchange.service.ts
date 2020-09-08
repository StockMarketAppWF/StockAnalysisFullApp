import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Exchange } from "../exchange";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ExchangeService {
  private _url: string =
    "http://localhost:3795/stockexchange/getstockexchangelist";
  constructor(private http: HttpClient) {}
  getItems(): Observable<Exchange[]> {
    console.log("Here");
    return this.http.get<Exchange[]>(this._url);
  }
}
