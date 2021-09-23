import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BeerlistService {

  private apiUrl: string = `${environment.apiUrl}/beerlist`;

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(this.apiUrl);
  }

  add(beerList: any) {
    return this.http.post(this.apiUrl, beerList);
  }

  update(beerList: any) {
    return this.http
      .put(`${this.apiUrl}/${beerList.id}`, beerList);
  }

  delete(beerList: any) {
    return this.http
      .delete(`${this.apiUrl}/${beerList.id}`);
  }
}
