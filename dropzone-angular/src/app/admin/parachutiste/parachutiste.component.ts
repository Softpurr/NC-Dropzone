import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ParachuteService } from 'src/app/parachute.service';



@Component({
  selector: 'app-parachutiste',
  templateUrl: './parachutiste.component.html',
  styleUrls: ['./parachutiste.component.css']
})
export class ParachutisteComponent implements OnInit {
  parachutistes: any = [];
  formParachutiste = {
    nom: "", prenom: "", numero_licence: "", date: null, isSaut:false, isPratiquant:false,
    isConfirme: false, parachutes:null, saut:null, vol:null
  };

  constructor(private srvParachutiste: ParachuteService, private modalService: NgbModal) { 
    this.refresh();
  }

  ngOnInit(): void {
  }

  refresh = () => this.parachutistes = this.srvParachutiste.findAll();

  ajouterCategorie() {
    this.srvParachutiste.add(this.formParachutiste).subscribe(this.refresh);
  }

  editerCategorie(parachute: any) {
    this.formParachutiste = parachute;
  }

  modifierCategorie() {
    this.srvParachutiste.update(this.formParachutiste).subscribe(this.refresh);
  }

  supprimerCategorie(parachutiste: any) {
    this.srvParachutiste.delete(parachutiste).subscribe(this.refresh);
  }

}
