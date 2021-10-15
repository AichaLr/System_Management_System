import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../models/order';
import { Product } from '../models/product';
const API_URL = 'http://localhost:8081/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'text', { responseType: 'text' });
  }

  addorder(order: Order): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post('http://localhost:8081/api/auth/addorder', order, {
      headers: headers,
    });
  }

  addproduct(product: Product): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post(
      'http://localhost:8081/api/auth/addproduct',
      product,
      {
        headers: headers,
      }
    );
  }

  updatestatus(id, status): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post(
      'http://localhost:8081/api/auth/updateorder/' + id + '/' + status,
      {
        headers: headers,
      }
    );
  }
}
