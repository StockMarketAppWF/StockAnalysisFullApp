import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {


  company={
   company_id:0,
   company_name:'',
   turnover:'',
	 ceo:'',
	 board_of_directors:'',
   write_up:'',
   sector_id:''
  };
  
  submitted=false;

  constructor(private companyService: CompanyService) { }

  ngOnInit() 
  {
  }

  saveCompany() {
     const data = {
      company_id:this.company.company_id,
      company_name:this.company.company_name,
      turnover:this.company.turnover,
	    ceo:this.company.ceo,
	    board_of_directors:this.company.board_of_directors,
      write_up:this.company.write_up,
      sector_id:this.company.sector_id
    };
    console.log(data);
    this.companyService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newCompany() {
    this.submitted = false;
    this.company = {
      company_id:0,
      company_name:'',
      turnover:'',
      ceo:'',
      board_of_directors:'',
      write_up:'',
      sector_id:''
     
    };
  }
}
