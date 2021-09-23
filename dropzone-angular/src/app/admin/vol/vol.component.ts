import { Component, OnInit } from '@angular/core';
import { AvionService } from 'src/app/avion.service';
import { ParachutisteService } from 'src/app/parachutiste.service';
import { PiloteService } from 'src/app/pilote.service';
import { SautService } from 'src/app/saut.service';
import { VolService } from 'src/app/vol.service';

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.css']
})
export class VolComponent implements OnInit {

  avions: any = [];
  pilotes: any = [];
  responsables: any = [];
  vols: any = [];
  sauts: any = [];
  formVol: any = {
    nombreSaut: 0,
    avion: null,
    pilote: null,
    etat: "",
    responsable: null,
  };
  modification: boolean = false;
  etats:any = [];

  refresh = () => {
    this.vols = this.srvVol.findAll();
    this.avions = this.srvAvion.findAll();
    this.pilotes = this.srvPilote.findAll();
    this.responsables = this.srvParachutiste.findConfirme();
    this.sauts = this.srvSaut.findAll();
  }

  constructor(private srvVol: VolService, private srvSaut: SautService, private srvAvion: AvionService, private srvPilote: PiloteService, private srvParachutiste: ParachutisteService) {
    this.refresh();
    this.etats = srvVol.findEtats();
  }

  ngOnInit(): void {
  }

  ajouterVol() {
    this.formVol.avion = {id: this.formVol.avion};
    this.formVol.pilote = {id: this.formVol.pilote};
    this.formVol.responsable = {id: this.formVol.responsable};
    this.srvVol.add(this.formVol).subscribe(this.refresh);
  }

  editerVol(vol: any) {
    this.formVol = vol;
    this.modification = true;
  }

  modifierVol() {
    this.srvVol.update(this.formVol).subscribe(this.refresh);
    this.formVol = {nombreSaut: 0, avion: null, pilote: null, etat: "",responsable: null,};
    this.modification = false;
  }

  supprimerVol(vol: any) {
    this.srvVol.delete(vol).subscribe(this.refresh);
  }

}