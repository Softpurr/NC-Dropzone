import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ParachuteService } from 'src/app/parachute.service';
import { ParachutisteService } from 'src/app/parachutiste.service';



@Component({
  selector: 'app-parachutiste',
  templateUrl: './parachutiste.component.html',
  styleUrls: ['./parachutiste.component.css']
})
export class ParachutisteComponent implements OnInit {
  parachutistes: any = [];
  parachutesPossede: any = [];
  parachutes: any = [];
  parachutiste: any= {};
  formParachutiste = {
    nomParachutiste:"", prenomParachutiste: "", numLicence: "", dateLicence: null, isSaut:false, isPratiquant:false,
    isConfirme: false, parachutes:null, saut:null, vol:null
  };

  constructor(private srvParachutiste: ParachutisteService, private srvParachute: ParachuteService, private modalService: NgbModal) { 
    this.refresh();
    this.parachutesPossede = this.srvParachute.findAllByParachutisteId(this.parachutiste);
    this.parachutes = this.srvParachute.findAll();
  }

  ngOnInit(): void {
  }

  refresh = () => this.parachutistes = this.srvParachutiste.findAll();

  ajouterParachutiste() {
    this.srvParachutiste.add(this.formParachutiste).subscribe(this.refresh);
  }

  editerParachutiste(parachute: any) {
    this.formParachutiste = parachute;
  }

  modifierParachutiste() {
    this.srvParachutiste.update(this.formParachutiste).subscribe(this.refresh);
    this.formParachutiste = {nomParachutiste:"", prenomParachutiste: "", numLicence: "", dateLicence: null, isSaut:false, isPratiquant:false,
    isConfirme: false, parachutes:null, saut:null, vol:null};
  }

  supprimerParachutiste(parachutiste: any) {
    this.srvParachutiste.delete(parachutiste).subscribe(this.refresh);
  }

}
