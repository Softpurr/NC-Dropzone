import { Component, OnInit } from '@angular/core';
import { PiloteService } from 'src/app/pilote.service';

@Component({
  selector: 'app-pilote',
  templateUrl: './pilote.component.html',
  styleUrls: ['./pilote.component.css']
})
export class PiloteComponent implements OnInit {

  constructor(private srvPilote : PiloteService) {

    this.pilotes = this.srvPilote.findAll();
   }

  ngOnInit(): void {
  }

  formPilote = {
    nom:"", prenom:"", numLicence:""
  }

  pilotes: any = [];

  refresh = () => this.pilotes = this.srvPilote.findAll();

  ajouterPilote() {
    this.srvPilote.add(this.formPilote).subscribe(this.refresh);
  }

  supprimerPilote(pilote: any) {
    this.srvPilote.delete(pilote).subscribe(this.refresh);

    
  }

  editerPilote(pilote: any) {
    this.formPilote= pilote;
  }

  modifierPilote() {
    this.srvPilote.update(this.formPilote).subscribe(this.refresh);
    this.formPilote = {nom:"", prenom:"", numLicence:""};
  }

}
