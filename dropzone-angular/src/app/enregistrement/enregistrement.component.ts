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
  isParachutiste = false;
  isEnregistre = false;

  hauteur = 0;
  hauteurs: any = [];

  cout = 0;

  typesSaut: any = [];

  parachutiste: any = {};
  parachutistes: any = [];
  parachutistesByNom: any = [];
  parachutistesSaut: any = [];

  sauts: any = [];

  // parachute: any = {};
  // parachutes: any = [];
  // parachutesSaut: any = [];

  refresh = () => this.sauts = this.srvSaut.findAll();

  constructor(private srvParachutiste: ParachutisteService, private srvSaut: SautService, private srvParachute: ParachuteService) {
    this.parachutistes = srvParachutiste.findAll();
    // this.parachutes = srvParachute.findAll();
    this.hauteurs = srvSaut.findHauteurs();
    this.typesSaut = srvSaut.findTypes();
  }

  ngOnInit(): void {
  }

  rechercherParachutiste(nom: string) {
    this.parachutistesByNom = this.srvParachutiste.findByNom(nom).subscribe(p => {
      this.parachutistesByNom = p;
    });
  }

  ajouterParachutiste(parachutiste: any) {
    this.parachutiste = { ...parachutiste };

    let isPresent = false;

    for (let p of this.parachutistesSaut) {
      if (this.parachutiste.id == p.id) {
        isPresent = true;
        break;
      }
    }

    if (!isPresent) {
      this.parachutistesSaut.push({ ...this.parachutiste });
    }

    this.isParachutiste = false;
    if (this.parachutistesSaut.length > 0) {
      this.isParachutiste = true;
    }

    this.calculCout();
  }

  retirerParachutiste(parachutiste: any) {
    this.parachutiste = { ...parachutiste };

    for (let p of this.parachutistesSaut) {
      if (this.parachutiste.id == p.id) {
        this.parachutistesSaut.splice(this.parachutistesSaut.indexOf(p), 1);
        break;
      }
    }

    this.isParachutiste = true;
    if (this.parachutistesSaut.length == 0) {
      this.isParachutiste = false;
    }

    this.calculCout();
  }

  calculCout() {
    let coutBuffer = 0;

    for (let p of this.parachutistesSaut) {
      if (this.hauteur == 6000) {
        let c = 30;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (this.hauteur == 4000) {
        let c = 26;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (this.hauteur == 2500) {
        let c = 22;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (this.hauteur == 2000) {
        let c = 18;
        if (p.isConfirme) {
          coutBuffer += c * 0.9;
        }
        else {
          coutBuffer += c;
        }
      }
      else if (this.hauteur == 1600) {
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
    let saut = [
      { hauteur: this.hauteur },
      { parachutistes: { ... this.parachutistesSaut } },
    ]

    console.log(saut);
    console.log(this.srvSaut.add(saut));

    this.srvSaut.add(saut).subscribe(this.refresh);
  }

}
