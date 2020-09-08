import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const baseUrl = 'http://localhost:8081';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  constructor(private http: HttpClient) { }

  getAll()
  {
    return this.http.get(`${baseUrl}/getipo`); 
  }

  get(id) {
    return this.http.get(`${baseUrl}/getipobyid/${id}`);
  }

  create(data) {
    console.log(data);
    return this.http.post(`${baseUrl}/insertipo`, data);
  }

  update(id, data) {
    console.log(data,id);
    return this.http.put(`${baseUrl}/updateipo/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/deleteipo/${id}`);
  }

}






