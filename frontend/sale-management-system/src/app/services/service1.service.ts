import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
const API_URL = 'http://localhost:8081/api/test/';

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'text', { responseType: 'text' });
  }
}
