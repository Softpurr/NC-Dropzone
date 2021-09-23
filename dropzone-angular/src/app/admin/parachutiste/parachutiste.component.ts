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
  parachutiste: any = {};
  parachutisteId: any = {};

  parachutesPossede: any = [];
  parachutesNonPossede: any = [];
  parachutesLibre: any = [];
  parachutes: any = [];
  
  @ViewChild('modal') modal: any;

  formParachutiste = {
    nomParachutiste: "", prenomParachutiste: "", numLicence: "", dateLicence: null, isSaut: false, isPratiquant: false,
    isConfirme: false, parachutes: null, saut: null, vol: null
  };

  formParachute = { id: 0, nomHarnais: "" , nomVoilePrincipale:"", nomVoileSecours: "", tailleVoilePrincipale:0,
  tailleVoileSecours:0, datePliageVoileSecours: null, securite:null, isPerso: false, 
  isDispo: false, parachutiste:null, saut:null }

  constructor(private srvParachutiste: ParachutisteService, private srvParachute: ParachuteService) {
    this.refresh();

    this.parachutes = this.srvParachute.findAll();
    this.parachutesNonPossede = this.srvParachute.findAllIsPersoFalse();
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
    // if (this.formParachutiste.parachutes !== null){
    //   this.srvParachutiste.findByNumLicence(this.formParachutiste.numLicence).subscribe(element => this.parachutisteId = element)
    //   console.log(this.parachutisteId);
    // }
  }

  editerParachutiste(parachutiste: any) {
    this.formParachutiste = parachutiste;
  }

  modifierParachutiste() {
    this.srvParachutiste.update(this.formParachutiste).subscribe(this.refresh);
    this.formParachutiste = {
      nomParachutiste: "", prenomParachutiste: "", numLicence: "", dateLicence: null, isSaut: false, isPratiquant: false,
      isConfirme: false, parachutes: null, saut: null, vol: null
    };
  }

  supprimerParachutiste(parachutiste: any) {
    this.srvParachutiste.delete(parachutiste).subscribe(this.refresh);
  }

}
