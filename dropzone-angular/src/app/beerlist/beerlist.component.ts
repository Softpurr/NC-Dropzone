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
  parachutistes : any = [];
  parachutiste : any = {};

  formBeerList = {
    parachutiste: {
      id:0, nomParachutiste:"", prenomParachutiste:"", numLicence:""
    },
  }

  constructor(private srvBeerList: BeerlistService, private srvParachutiste: ParachutisteService) {
    this.refresh();

    this.parachutistes = this.srvParachutiste.findAll();
   }

  ngOnInit(): void {
  }

  refresh = () => this.beerList = this.srvBeerList.findAll();

  ajouterBeerList() {
    this.srvBeerList.add(this.formBeerList).subscribe(this.refresh);
  }

  editerBeerList(beerList: any) {
    this.formBeerList = beerList;
  }

  modifierBeerList() {
    this.srvBeerList.update(this.formBeerList).subscribe(this.refresh);
    this.formBeerList = {
      parachutiste: {
        id: 0,nomParachutiste:"", prenomParachutiste:"", numLicence:""
      }
    };
  }

  supprimerParachutiste(beerList: any) {
    this.srvBeerList.delete(beerList).subscribe(this.refresh);
  }

}
