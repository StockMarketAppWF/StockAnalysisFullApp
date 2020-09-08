import { Component, OnInit } from '@angular/core';
import {CompanyService} from 'src/app/services/company.service';
@Component({
  selector: 'app-view-company',
  templateUrl: './viewcompany.component.html',
  styleUrls: ['./viewcompany.component.css']
})

export class ViewCompanyComponent implements OnInit {
  title = 'Search Companies';
  searchText;
  companies:any;

  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.retrieveCompanies();
  }

  retrieveCompanies() {
    this.companyService.getAll()
      .subscribe(
        data => {
          this.companies = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

 
}

