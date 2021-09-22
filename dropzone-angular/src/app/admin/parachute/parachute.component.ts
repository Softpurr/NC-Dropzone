import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ParachuteService } from 'src/app/parachute.service';

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

  constructor(private srvParachute: ParachuteService, private modalService: NgbModal) { 
    this.refresh();
  }

  ngOnInit(): void {
  }

  refresh = () => this.parachutes = this.srvParachute.findAll();

  ajouterParachute() {
    this.srvParachute.add(this.formParachute).subscribe(this.refresh);
  }

  editerParachute(parachute: any) {
    this.formParachute = parachute;
  }

  modifierParachute() {
    this.srvParachute.update(this.formParachute).subscribe(this.refresh);
    this.formParachute = {nomHarnais: "" , nomVoilePrincipale:"", nomVoileSecours: "", tailleVoilePrincipale:0,
    tailleVoileSecours:0, datePliageVoileSecours: null, securite:null, isPerso: false, 
    isDispo: false, parachutiste:null, saut:null};
  }

  supprimerParachute(parachute: any) {
    this.srvParachute.delete(parachute).subscribe(this.refresh);
  }

}
