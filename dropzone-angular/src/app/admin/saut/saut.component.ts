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

  formSaut = {
    hauteur: null,
    typeSaut: null,
    parachutistes: null,
  }
  sauts: any = [];

  refresh = () => {
    this.sauts = this.srvSaut.findAll();
    this.parachutistes = this.srvParachutiste.findAll();
  };

  constructor(private srvSaut: SautService, private srvParachutiste: ParachutisteService) {
    this.hauteurs = this.srvSaut.findHauteurs();
    this.types = this.srvSaut.findTypes();
    this.refresh();
  }

  ngOnInit(): void {
  }

  ajouterSaut() {
    this.srvSaut.add(this.formSaut).subscribe(this.refresh);
    this.annuler();
  }

  supprimerSaut(saut: any) {
    this.srvSaut.delete(saut).subscribe(this.refresh);
  }

  editerSaut(saut: any) {
    this.isEdition = true;
    this.formSaut = { ...saut };
  }

  modifierSaut() {
    this.srvSaut.update(this.formSaut).subscribe(this.refresh);
    this.annuler();
  }

  annuler() {
    this.isEdition = false;
    this.formSaut = {
      hauteur: null,
      typeSaut: null,
      parachutistes: null,
    }
  }
}
