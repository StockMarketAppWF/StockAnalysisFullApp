import { Component, OnInit } from '@angular/core';
import * as myGlobals from '../../global'
import * as NavComp from '../../app.component';
import { Router , Routes} from '@angular/router';


@Component({
  selector: 'app-dashbaord',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  loggedin = myGlobals.getStatus();
  constructor(private navComp: NavComp.AppComponent, private router: Router) { 
    if(myGlobals.getStatus()==false){
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {
    this.navComp.login();
    this.loggedin = myGlobals.getStatus();
  }

}
