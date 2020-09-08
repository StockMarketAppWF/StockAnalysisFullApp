import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { loginUser } from 'src/app/loginUser';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router , Routes} from '@angular/router';
import * as myGlobals from '../../global';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private userService:UserService, private router: Router) { }

  loginId : loginUser=new loginUser();
  submitted = false;
  errorFlag = false;
  invalid = false;

  ngOnInit() {
    this.submitted=false;
    this.errorFlag = false;
  }

  userLoginForm = new FormGroup({
    username:new FormControl('' , [Validators.required  ] ),
    password:new FormControl('' , [Validators.required  ] ),
  });

  goLoginUser(goLoginUser){
    this.loginId = new loginUser();
    this.loginId.username = this.getUserName.value;
    this.loginId.password = this.getUserPassword.value;
    this.save();
  }

  

  save() {
    this.userService.loginUser(this.loginId)
      .subscribe(data => {
        console.log(data)
        this.submitted = true;
        myGlobals.loggingin();
        this.router.navigate(['/success']);
      }, error => {
      console.log(error)
        this.errorFlag = true;
        this.invalid = true;
        this.userLoginForm.reset();
    }
      
      );
  }

  get getUserName(){
    return this.userLoginForm.get('username');
  }

  get getUserPassword(){
    return this.userLoginForm.get('password');
  }

}
