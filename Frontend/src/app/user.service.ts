import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import * as myGlobals from './global';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  public isLoggedIn = false;
  private baseUrl = 'http://localhost:8085/';
  headerJwt;
  constructor(private http:HttpClient) { }

  
  createStudent(student: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'signin', student);
  }

  getUserData(loginId: object): Observable<object> {
    this.headerJwt = "bearer " + myGlobals.getJwt();
    const headers = new HttpHeaders().set('Authorization', this.headerJwt);
    console.log(headers);
    return this.http.get('${this.baseUrl}' + 'user/' + myGlobals.getUname, {headers});
  }

  loginUser(loginId: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'login', loginId);
  }

  loginAdmin(loginId: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'adminlogin', loginId);
  }

  login(): boolean{
    return true;
  }
  logout(): boolean{
    return false;
  }
  
}                                           
