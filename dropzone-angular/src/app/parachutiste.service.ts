import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ParachutisteService {

  private apiUrl: string = `${ environment.apiUrl }/parachutiste`;

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(this.apiUrl);
  }

  findConfirme() {
    return this.http.get(`${this.apiUrl}/confirme`)
  }
  
  add(parachutiste: any) {
    console.log(parachutiste);
    return this.http.post(this.apiUrl, parachutiste);
  }

  update(parachutiste: any) {
    return this.http
      .put(`${ this.apiUrl }/${ parachutiste.id }`, parachutiste);
  }

  delete(parachutiste: any) {
    return this.http
      .delete(`${ this.apiUrl }/${ parachutiste.id }`);
  }
}
