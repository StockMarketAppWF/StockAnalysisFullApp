import { Component, OnInit } from '@angular/core';
import {IpoService} from 'src/app/services/ipo.service';
@Component({
  selector: 'app-view-ipo',
  templateUrl: './viewipo.component.html',
  styleUrls: ['./viewipo.component.css']
})

export class ViewIpoComponent implements OnInit {
  title = 'Search IPO';
  searchText;
  ipos:any;

  constructor(private ipoService: IpoService) { }

  ngOnInit() {
    this.retrieveIPOs();
  }

  retrieveIPOs() {
    this.ipoService.getAll()
      .subscribe(
        data => {
          this.ipos = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

 
}

