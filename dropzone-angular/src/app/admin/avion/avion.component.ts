import { Component, OnInit } from '@angular/core';
import { AvionService } from 'src/app/avion.service';

@Component({
  selector: 'app-avion',
  templateUrl: './avion.component.html',
  styleUrls: ['./avion.component.css']
})
export class AvionComponent implements OnInit {

  avions: any = [];
  avionForm: any = {
    nomAvion:"",
    capaciteTransport:0,
    rotationMax:0,
    isDispo: false
  };

  refresh = () => {
    this.avions = this.serviceAvion.findAll();
  }

  supprimerAvion(avion: any){
    this.serviceAvion.delete(avion).subscribe(this.refresh);
  }
  editerAvion(avion: any){
    this.avionForm = avion;
  }
  modifierAvion(){
    this.serviceAvion.update(this.avionForm).subscribe(this.refresh);
  }
  ajouterAvion(){
    this.serviceAvion.add(this.avionForm).subscribe(this.refresh);
  }

  constructor(private serviceAvion: AvionService) { 
    this.refresh();
  }

  ngOnInit(): void {
  }


}
