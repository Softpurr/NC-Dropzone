import { Component, OnInit } from '@angular/core';
import { ParachutisteService } from 'src/app/parachutiste.service';
import { SautService } from 'src/app/saut.service';

@Component({
  selector: 'app-saut',
  templateUrl: './saut.component.html',
  styleUrls: ['./saut.component.css']
})
export class SautComponent implements OnInit {
  isEdition = false;

  hauteurs: any = [];
  types: any = [];

  parachutistes: any = [];
  parachutistesSaut: any = [];

  parachutistesId: any = [];

  formSaut = {
    hauteur: null,
    typeSaut: null,
    parachutistes: [],
  }
  sauts: any = [];

  refresh = () => this.sauts = this.srvSaut.findAll();

  constructor(private srvSaut: SautService, private srvParachutiste: ParachutisteService) {
    this.parachutistes = srvParachutiste.findAll();
    this.hauteurs = srvSaut.findHauteurs();
    this.types = srvSaut.findTypes();
    this.refresh();
  }

  ngOnInit(): void {
  }

  ajouterSaut() {
    this.traductionIdEnParachutiste();

    this.srvSaut.add(this.formSaut).subscribe(this.refresh);
  }

  supprimerSaut(saut: any) {
    this.srvSaut.delete(saut).subscribe(this.refresh);
  }

  editerSaut(saut: any) {
    this.isEdition = true;
    this.formSaut = { ...saut };
  }

  modifierSaut() {
    this.isEdition = false;

    this.traductionIdEnParachutiste();

    this.srvSaut.update(this.formSaut).subscribe(this.refresh);
    this.formSaut = {
      hauteur: null,
      typeSaut: null,
      parachutistes: [],
    }
  }

  traductionIdEnParachutiste() {
    for (let i of this.parachutistesId) {
      let p = this.srvParachutiste.findById(i);
      this.parachutistesSaut.push({ ...p });
    }
    this.formSaut.parachutistes = { ...this.parachutistesSaut };
  }
}
