import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL = 'http://localhost:8081/api/test/';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getFournisseurBoard(): Observable<any> {
    return this.http.get(API_URL + 'fournisseur', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'responsable', { responseType: 'text' });
  }
  getlistfournisseurs(): Observable<any> {
    return this.http.get(API_URL + 'listfournisseur');
  }
  getfournisseur(id): Observable<any> {
    return this.http.get(API_URL + 'fournisseurrr/' + id);
  }
  getproduit(id): Observable<any> {
    return this.http.get(API_URL + 'produit/' + id);
  }
  getlistproduits(): Observable<any> {
    return this.http.get(API_URL + 'listproduits');
  }
  getlistorders(): Observable<any> {
    return this.http.get(API_URL + 'listcommandes');
  }
  getfournisseurorders(id): Observable<any> {
    return this.http.get(API_URL + 'etatcommande/' + id);
  }
}
