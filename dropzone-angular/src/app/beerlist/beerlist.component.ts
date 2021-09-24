import { Component, OnInit } from '@angular/core';
import { BeerlistService } from '../beerlist.service';
import { ParachutisteService } from '../parachutiste.service';

@Component({
  selector: 'app-beerlist',
  templateUrl: './beerlist.component.html',
  styleUrls: ['./beerlist.component.css']
})
export class BeerlistComponent implements OnInit {

  beerList: any = [];

  parachutistes: any = [];

  beerListForm = {};

  constructor(private srvBeerList: BeerlistService, private srvParachutiste: ParachutisteService) {
    this.refresh();
  }

  ngOnInit(): void {
  }

  refresh = () => {
    this.beerList = this.srvBeerList.findAll();
    this.parachutistes = this.srvParachutiste.findAll();
  };


  ajouterBeerList() {
    console.log(this.beerListForm);
    this.srvBeerList.add(this.beerListForm).subscribe(this.refresh);
  }

  editerBeerList(b: any) {
    this.beerListForm = b;
  }

  modifierBeerList() {
    this.srvBeerList.update(this.beerListForm).subscribe(this.refresh);
  }

  supprimerParachutiste(b: any) {
    this.srvBeerList.delete(b).subscribe(this.refresh);
  }

}
