import { Component, ComponentFactoryResolver } from '@angular/core';
import {UserService} from './user.service'
import * as myGlobals from './global';
import { logging } from 'protractor';
import { Router , Routes} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router) { }
  title = 'FormSubmit';
  isLogged = myGlobals.getStatus();
  login(){
    console.log("Login boolean : " + this.isLogged);
    myGlobals.loggingin();
    this.isLogged = true;
    console.log("Login boolean : " + this.isLogged);
  }

  logout(){
    myGlobals.logout();
    this.isLogged = false;
    console.log("Login boolean : " + this.isLogged);
    this.router.navigate(['/']);
  }

}


