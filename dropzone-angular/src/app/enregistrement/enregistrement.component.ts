import { Component, OnInit } from '@angular/core';
import { ParachutisteService } from '../parachutiste.service';

@Component({
  selector: 'app-enregistrement',
  templateUrl: './enregistrement.component.html',
  styleUrls: ['./enregistrement.component.css']
})
export class EnregistrementComponent implements OnInit {
  isValide = false;
  isPratiquant = false;

  parachutiste: any = {};
  parachutistesByNom: any = [];

  constructor(private srvParachutiste: ParachutisteService) {
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

}
