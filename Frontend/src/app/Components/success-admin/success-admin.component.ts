import { Component, OnInit } from '@angular/core';
import * as myGlobals from '../../global'
import * as NavComp from '../../app.component';
import { Router , Routes} from '@angular/router';

@Component({
  selector: 'app-success-admin',
  templateUrl: './success-admin.component.html',
  styleUrls: ['./success-admin.component.css']
})
export class SuccessAdminComponent implements OnInit {

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
