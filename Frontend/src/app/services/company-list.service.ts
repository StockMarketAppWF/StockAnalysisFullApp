import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Company } from "../company";

@Injectable({
  providedIn: "root",
})
export class CompanyListService {
  private _url: string = "";
  constructor(private http: HttpClient) {}
  getCompany(): Observable<Company[]> {
    console.log("Here");
    return this.http.get<Company[]>(this._url);
  }
}
