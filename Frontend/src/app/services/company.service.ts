import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8081';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  getAll()
  {
    return this.http.get(`${baseUrl}/getcompany`); 
  }

  searchCompany(pattern)
  {
    return this.http.get(`${baseUrl}/searchcompany/${pattern}`); 
  }

  get(id) {
    return this.http.get(`${baseUrl}/getcompanybyid/${id}`);
  }

  create(data) {
    
    return this.http.post(`${baseUrl}/insertcompany`, data);
  }

  update(id, data) {
    
    return this.http.put(`${baseUrl}/updatecompany/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/deactivatecompany/${id}`);
  }

}

