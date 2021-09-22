import { Component, OnInit, ViewChild } from '@angular/core';
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
  @ViewChild('modal') modal: any;


  formParachutiste = {
    nomParachutiste:"", prenomParachutiste: "", numLicence: "", dateLicence: null, isSaut:false, isPratiquant:false,
    isConfirme: false, parachutes:null, saut:null, vol:null
  };

  constructor(private srvParachutiste: ParachutisteService, private srvParachute: ParachuteService) { 
    this.refresh();
    
    this.parachutes = this.srvParachute.findAll();
  }

  ngOnInit(): void {
  }

  refresh = () => this.parachutistes = this.srvParachutiste.findAll();

  voirParachutePossede(parachutiste: any) {
    this.modal.open();
    this.parachutiste = parachutiste;
    this.parachutesPossede = this.srvParachute.findAllByParachutisteId(parachutiste).subscribe(parachutesPossede => this.parachutesPossede = parachutesPossede);
  }

  ajouterParachutiste() {
    this.srvParachutiste.add(this.formParachutiste).subscribe(this.refresh);
  }

  editerParachutiste(parachutiste: any) {
    this.formParachutiste = parachutiste;
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
