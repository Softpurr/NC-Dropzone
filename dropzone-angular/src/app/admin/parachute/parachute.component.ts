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
  formParachutes: any = { nomHarnais: "" , nomVoilePrincipale:"", nomVoileSecours: "", tailleVoilePrincipale:0,
  tailleVoileSecours:0, datePliageVoileSecours: 21/08/2021, securite:null, isPerso: false, 
  isDispo: false, parachutiste:null, saut:null }

  constructor(private srvParachute: ParachuteService, private modalService: NgbModal) { 
    this.refresh();
  }

  ngOnInit(): void {
  }

  refresh = () => this.parachutes = this.srvParachute.findAll();

  ajouterCategorie() {
    this.srvParachute.add(this.formParachutes).subscribe(this.refresh);
  }

  editerCategorie(parachute: any) {
    this.formParachutes = parachute;
  }

  modifierCategorie() {
    this.srvParachute.update(this.formParachutes).subscribe(this.refresh);
  }

  supprimerCategorie(parachute: any) {
    this.srvParachute.delete(parachute).subscribe(this.refresh);
  }

}
