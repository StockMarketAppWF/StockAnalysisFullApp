import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { Exchange } from "../exchange";

@Injectable({
  providedIn: "root",
})
export class DetailService {
  private itemdata = new BehaviorSubject<Exchange>(null);
  public share = this.itemdata.asObservable();
  constructor() {}

  updateitemdata(item) {
    this.itemdata.next(item);
  }

  ngOnInit() {
    const item = localStorage.getItem("itemlist");
    if (item) {
      this.itemdata = JSON.parse(item);
    } else {
      this.itemdata = null;
    }
  }
}
