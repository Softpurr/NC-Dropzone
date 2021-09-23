import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ParachutisteService {

  private apiUrl: string = `${environment.apiUrl}/parachutiste`;

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(this.apiUrl);
  }

  findConfirme() {
    return this.http.get(`${this.apiUrl}/confirme`)
  }

  findByNumLicence(numLicence: String) {
    return this.http.get(`${this.apiUrl}/by-parachutiste/${numLicence}`)
  }

  findByNom(nom: String) {
    return this.http.get(`${this.apiUrl}/by-nom/${nom}`);
  }

  findByLicence(licence: String) {
    return this.http.get(`${this.apiUrl}/by-licence/${licence}`);
  }

  add(parachutiste: any) {
    return this.http.post(this.apiUrl, parachutiste);
  }

  update(parachutiste: any) {
    return this.http
      .put(`${this.apiUrl}/${parachutiste.id}`, parachutiste);
  }

  delete(parachutiste: any) {
    return this.http
      .delete(`${this.apiUrl}/${parachutiste.id}`);
  }
}
