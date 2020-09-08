import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Exchange } from "../exchange";
import { Observable } from "rxjs";
import { HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class EditExchangeService {
  private headers = new HttpHeaders({
    "Content-Type": "application/json",
  });
  private options = { headers: this.headers };
  private _url: string = "http://localhost:3795/stockexchange/addstockexchange";

  constructor(private http: HttpClient) {}
  sendExchangeData(editData): Observable<Exchange> {
    return this.http.post<Exchange>(this._url, editData, this.options);
  }
}
