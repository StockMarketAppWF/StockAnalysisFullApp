import { Component, OnInit } from '@angular/core';
import { IpoService } from 'src/app/services/ipo.service';
import * as myGlobals from './../../global';
import { Router } from "@angular/router";

@Component({
  selector: 'app-add-ipo',
  templateUrl: './add-ipo.component.html',
  styleUrls: ['./add-ipo.component.css']
})
export class AddIpoComponent implements OnInit {
  ipo={
    ipo_id:0,
	  num_of_shares:'',
    open_date:'',
	  price_per_share:0.0,
    remarks:'',
    company_id:0
  };
  
  submitted=false;



  constructor(private ipoService: IpoService, private router: Router) {
    if(myGlobals.getStatus()==false){
      this.router.navigate(['/']);
    }

   }

  ngOnInit() 
  {
  }

  saveIpo() {
     const data = {
      ipo_id:this.ipo.ipo_id,
      num_of_shares:this.ipo.num_of_shares,
      open_date:this.ipo.open_date,
      price_per_share:this.ipo.price_per_share,
      remarks:this.ipo.remarks,
      company_id:this.ipo.company_id
    };

    this.ipoService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newIpo() {
    this.submitted = false;
    this.ipo = {
      ipo_id:0,
      num_of_shares:'',
      open_date:'',
      price_per_share:0.0,
      remarks:'',
      company_id:0
     
    };
  }
}
