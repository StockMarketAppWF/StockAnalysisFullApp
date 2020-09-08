import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import {IpoService } from 'src/app/services/ipo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ipo-list',
  templateUrl: './ipo-list.component.html',
  styleUrls: ['./ipo-list.component.css']
})

export class IpoListComponent implements OnInit {

  ipos: any;
  currentIpo = null;
  currentIndex = -1;
  id = 2;
  
  constructor(
    private ipoService: IpoService,
    private route: ActivatedRoute,
    private router: Router) { }
  // constructor(private ipoService: IpoService) { }

  ngOnInit() {
    this.retrieveIpos();
  }

  retrieveIpos() {
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

  refreshList() {
    this.retrieveIpos();
    this.currentIpo = null;
    this.currentIndex = -1;
  }

  setActiveIpo(ipo, index) {
    this.currentIpo = ipo;
    this.currentIndex = index;
  }


  searchIpo() {

   this.ipoService.get(this.id)
      .subscribe(
        data => {
          this.ipos = data;
          console.log(data);
        },
        error => {
          console.log(error);
          
        });
  }

  deleteIpo(ipo_id) {
    if(confirm("Are you sure to delete ?"))
    {
    this.ipoService.delete(ipo_id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/success/ipo']);
          window.location.reload(); 
        },
        error => {
          console.log(error);
          window.alert("Error!");
        });
    }
  }
}