import { Component, OnInit } from '@angular/core';
import { AvionService } from '../avion.service';
import { ParachutisteService } from '../parachutiste.service';
import { VolService } from '../vol.service';

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent implements OnInit {

  avions: any = [];
  parachutistes: any = [];
  vols: any = [];

  constructor(private srvVol: VolService, private srvAvion: AvionService, private srvParachutiste: ParachutisteService) {
    this.refresh();
   }

   refresh = () => {
    this.avions = this.srvAvion.findAll();
    this.vols = this.srvVol.findAll();
    this.parachutistes = this.srvParachutiste.findAll();
  }

  ngOnInit(): void {
  }

}
