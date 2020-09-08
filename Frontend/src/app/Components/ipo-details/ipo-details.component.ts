import { Component, OnInit } from '@angular/core';
import { IpoService } from 'src/app/services/ipo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ipo-details',
  templateUrl: './ipo-details.component.html',
  styleUrls: ['./ipo-details.component.css']
})
export class IpoDetailsComponent implements OnInit {
  currentipo = {
    ipo_id:0,
	  num_of_shares:'',
    open_date:'',
	  price_per_share:0.0,
    remarks:'',
    company_id:0
  };
  message = '';
  listdata:any;
  dataset:any;
  isupdated=false;


  constructor(
    private ipoService: IpoService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
  

   this.message = '';
   this.getIpo(this.route.snapshot.paramMap.get('id'));
  }
  // ngOnInit{
  // // const data={ ipo_id:this.currentipo.ipo_id,
  // //   num_of_shares:this.currentipo.num_of_shares,
  // //   open_date:this.currentipo.open_date,
  // //   price_per_share:this.ipo.price_per_share,
  // //   remarks:this.ipo.remarks,
  // //   company_id:this.ipo.company_id

  
  

  // };

  getIpo(id)
  {
    this.ipoService.get(id)
      .subscribe(
        data => {
         // this.currentcompany = data;
          console.log(data);
          this.dataset=data[0]
          this.currentipo=this.dataset;
          console.log("hey",this.currentipo);

        },
        error => {
          console.log(error);
        });
  }



  // getIpo(id) {
  //   this.ipoService.get(id)
  //     .subscribe(
  //       data => {
  //        // this.currentipo = data;
  //         console.log(data);
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }




  updateIpo() {
    const data={ ipo_id:this.currentipo.ipo_id,
      num_of_shares:this.currentipo.num_of_shares,
      open_date:this.currentipo.open_date,
      price_per_share:this.currentipo.price_per_share,
      remarks:this.currentipo.remarks,
      company_id:this.currentipo.company_id
    };
    console.log("hi",this.currentipo.ipo_id,data);
    this.ipoService.update(this.currentipo.ipo_id,data)
      .subscribe(
        response => {
          console.log(response);
          this.isupdated=true;
          this.message = 'The IPO was updated successfully!';
          window.alert(this.message);
          this.router.navigate(['/success/ipo']);
        },
        error => {
          console.log(error);
        });
  }

  // deleteIpo() {
  //   this.ipoService.delete(this.currentipo.ipo_id)
  //     .subscribe(
  //       response => {
  //         console.log(response);
  //         this.router.navigate(['/ipo']);
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }
}
