import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SautService {

  private apiUrl: string = `${environment.apiUrl}/saut`;

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(this.apiUrl);
  }

  findHauteurs() {
    return this.http.get(`${this.apiUrl}/hauteur`);
  }

  findTypes() {
    return this.http.get(`${this.apiUrl}/type`);
  }

  add(saut: any) {
    return this.http.post(this.apiUrl, saut);
  }

  update(saut: any) {
    return this.http
      .put(`${this.apiUrl}/${saut.id}`, saut);
  }

  delete(saut: any) {
    return this.http
      .delete(`${this.apiUrl}/${saut.id}`);
  }
}
