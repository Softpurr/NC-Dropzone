import { Component, OnInit } from '@angular/core';
import { ParachuteService } from '../parachute.service';
import { ParachutisteService } from '../parachutiste.service';
import { SautService } from '../saut.service';

@Component({
  selector: 'enregistrement',
  templateUrl: './enregistrement.component.html',
  styleUrls: ['./enregistrement.component.css']
})
export class EnregistrementComponent implements OnInit {
  isRecherche = false;
  isParachutiste = false;
  isEnregistre = false;

  hauteurs: any = [];

  cout = 0;

  nomParachutiste = "";

  parachutiste: any = {};
  parachutistes: any = [];
  parachutistesByNom: any = [];
  parachutistesSaut: any = [];

  saut: any = {
    hauteur: 0,
    parachutistes: [],
  };
  sauts: any = [];

  refresh = () => {
    this.sauts = this.srvSaut.findAll();
    this.parachutistes = this.srvParachutiste.findAll();
  }

  constructor(private srvParachutiste: ParachutisteService, private srvSaut: SautService, private srvParachute: ParachuteService) {
    this.hauteurs = srvSaut.findHauteurs();
    this.refresh();
  }

  ngOnInit(): void {
  }

  rechercherParachutiste(nom: string) {
    this.parachutistesByNom = this.srvParachutiste.findByNom(nom).subscribe(p => {
      this.parachutistesByNom = p;
    });

    this.isRecherche = true;
  }

  ajouterParachutiste(parachutiste: any) {
    this.parachutiste = { id: parachutiste.id };

    let isPresent = false;

    for (let p of this.saut.parachutistes) {
      if (this.parachutiste.id == p.id) {
        isPresent = true;
        break;
      }
    }

    if (!isPresent) {
      this.saut.parachutistes.push(this.parachutiste);
      this.parachutistesSaut.push(parachutiste);
    }

    this.isParachutiste = false;
    if (this.saut.parachutistes.length > 0) {
      this.isParachutiste = true;
    }

    this.calculCout();
  }

  retirerParachutiste(parachutiste: any) {
    this.saut.parachutistes.splice(this.saut.parachutistes.indexOf(parachutiste), 1);
    this.parachutistesSaut.splice(this.parachutistesSaut.indexOf(parachutiste), 1);

    this.isParachutiste = true;
    if (this.saut.parachutistes.length == 0) {
      this.isParachutiste = false;
    }

    this.calculCout();
  }

  calculCout() {
    let coutBuffer = 0;

    for (let p of this.parachutistesSaut) {
      let hauteur = this.saut.hauteur;
      if (hauteur == 6000) {
        let c = 30;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (hauteur == 4000) {
        let c = 26;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (hauteur == 2500) {
        let c = 22;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (hauteur == 2000) {
        let c = 18;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (hauteur == 1600) {
        let c = 14;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else {
        let c = 10;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
    }

    this.cout = parseFloat(coutBuffer.toFixed(2));
  }

  creerSaut() {
    console.log(this.saut);

    this.srvSaut.add(this.saut).subscribe(this.refresh);

    this.isEnregistre = true;
  }

  nouveauSaut() {
    this.isRecherche = false;
    this.isParachutiste = false;
    this.isEnregistre = false;

    this.cout = 0;

    this.nomParachutiste = "";

    this.parachutiste = {};
    this.parachutistes = [];
    this.parachutistesByNom = [];
    this.parachutistesSaut = [];

    this.saut = {
      hauteur: 0,
      parachutistes: [],
    };
    this.sauts = [];
  }

}
