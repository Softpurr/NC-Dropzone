import { Component, OnInit } from '@angular/core';
import { ParachuteService } from '../parachute.service';
import { ParachutisteService } from '../parachutiste.service';
import { SautService } from '../saut.service';

@Component({
  selector: 'app-enregistrement',
  templateUrl: './enregistrement.component.html',
  styleUrls: ['./enregistrement.component.css']
})
export class EnregistrementComponent implements OnInit {
  isValide = false;
  isEnregistre = false;
  
  hauteur: any = {};
  hauteurs: any = [];

  parachutiste: any = {};
  parachutistes: any = [];
  parachutistesByNom: any = [];
  parachutistesSaut: any = [];

  parachute: any = {};
  parachutes: any = [];
  parachutesSaut: any = [];

  constructor(private srvParachutiste: ParachutisteService, private srvSaut: SautService, private srvParachute: ParachuteService) {
    this.parachutistes = srvParachutiste.findAll();
    this.parachutes = srvParachute.findAll();
    this.hauteurs = srvSaut.findHauteurs();

    console.log(this.hauteurs);
  }

  ngOnInit(): void {
  }

  rechercherParachutiste(nom: string) {
    this.isValide = false;
    this.parachutistesByNom = this.srvParachutiste.findByNom(nom).subscribe(p => {
      this.parachutistesByNom = p;
    });
  }

  enregistrerParachutiste(parachutiste: any) {
    this.parachutiste = parachutiste;
    this.isValide = true;
  }

  creerSaut(saut: any) {
    this.srvSaut.add(saut);
  }

}
