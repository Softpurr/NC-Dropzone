import { Component, OnInit } from '@angular/core';
import { ParachuteService } from 'src/app/parachute.service';
import { ParachutisteService } from 'src/app/parachutiste.service';
import { SautService } from 'src/app/saut.service';
import { VolService } from 'src/app/vol.service';

@Component({
  selector: 'app-saut',
  templateUrl: './saut.component.html',
  styleUrls: ['./saut.component.css']
})
export class SautComponent implements OnInit {

  constructor(private srvSaut : SautService, private srvVol : VolService, private srvParachutiste : ParachutisteService, private srvParachute : ParachuteService) { 

    this.parachutistes = this.srvParachutiste.findAll();
    this.parachutes = this.srvParachute.findAll();

  }

  ngOnInit(): void {
  }

  formSaut = {
    hauteur: 0, typeSaut:null, parachutes: null, parachutistes: null
  }

  formParachutiste = {
    nom: "", prenom: "", numero_licence: "", date: 21/09/2021
  }
  formParachute = {
  }
  formVol = {

  }

  sauts: any = [];
  parachutistes: any = [];
  parachutes: any = [];
  refresh = () => this.sauts = this.srvSaut.findAll();

  ajouterSaut() {
    this.srvSaut.add(this.formSaut).subscribe(this.refresh);
  }

  supprimerSaut(saut: any) {
    this.srvSaut.delete(saut).subscribe(this.refresh);

    
  }

  editerSaut(saut: any) {
    this.formSaut= saut;
  }

  modifierSaut() {
    this.srvSaut.update(this.formSaut).subscribe(this.refresh);
    this.formSaut = {hauteur: 0, typeSaut:null, parachutes: null, parachutistes: null};
  }
}
