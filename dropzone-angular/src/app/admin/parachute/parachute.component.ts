import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ParachuteService } from 'src/app/parachute.service';
import { ParachutisteService } from 'src/app/parachutiste.service';

@Component({
  selector: 'app-parachute',
  templateUrl: './parachute.component.html',
  styleUrls: ['./parachute.component.css']
})
export class ParachuteComponent implements OnInit {
  parachutes: any = [];
  formParachute: any = { nomHarnais: "" , nomVoilePrincipale:"", nomVoileSecours: "", tailleVoilePrincipale:0,
  tailleVoileSecours:0, datePliageVoileSecours: null, securite:null, isPerso: false, 
  isDispo: false, parachutiste:null, saut:null }
  modification: boolean = false;
  parachutistes: any = [];
  securites: any = [];

  constructor(private srvParachute: ParachuteService, private srvParachutiste: ParachutisteService, private modalService: NgbModal) { 
    this.refresh();
    this.securites = this.srvParachute.findSecurites();
  }

  ngOnInit(): void {
  }

  refresh = () => {
    this.parachutes = this.srvParachute.findAll();
    this.parachutistes = this.srvParachutiste.findAll();
  }

  ajouterParachute() {
    this.formParachute.parachutiste = {id: this.formParachute.parachutiste};
    this.srvParachute.add(this.formParachute).subscribe(this.refresh);
  }

  editerParachute(parachute: any) {
    this.formParachute = parachute;
    this.modification = true;
  }

  modifierParachute() {
    this.srvParachute.update(this.formParachute).subscribe(this.refresh);
    this.formParachute = {nomHarnais: "" , nomVoilePrincipale:"", nomVoileSecours: "", tailleVoilePrincipale:0,
    tailleVoileSecours:0, datePliageVoileSecours: null, securite:null, isPerso: false, 
    isDispo: false, parachutiste:null, saut:null};
    this.modification = false;
  }

  supprimerParachute(parachute: any) {
    this.srvParachute.delete(parachute).subscribe(this.refresh);
  }

}
