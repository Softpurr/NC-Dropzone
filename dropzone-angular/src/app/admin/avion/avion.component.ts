import { Component, OnInit } from '@angular/core';
import { AvionService } from 'src/app/avion.service';

@Component({
  selector: 'app-avion',
  templateUrl: './avion.component.html',
  styleUrls: ['./avion.component.css']
})
export class AvionComponent implements OnInit {

  avions: any = [];
  formAvion: any = {
    nomAvion:"",
    capaciteTransport:0,
    rotationMax:0,
    isDispo: false
  };

  constructor(private srvAvion: AvionService) { 
    this.refresh();
  }

  ngOnInit(): void {
  }

  refresh = () => {
    this.avions = this.srvAvion.findAll();
  }

  supprimerAvion(avion: any){
    this.srvAvion.delete(avion).subscribe(this.refresh);
  }
  editerAvion(avion: any){
    this.formAvion = avion;
  }
  modifierAvion(){
    this.srvAvion.update(this.formAvion).subscribe(this.refresh);
    this.formAvion = {nomAvion:"", capaciteTransport:0, rotationMax:0,  isDispo: false};
  }
  ajouterAvion(){
    this.srvAvion.add(this.formAvion).subscribe(this.refresh);
  }
}
