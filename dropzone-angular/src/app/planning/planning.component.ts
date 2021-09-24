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
  enVol = "VOL"
  volsVol: any = [];
  volsPreparation: any = [];

  constructor(private srvVol: VolService, private srvAvion: AvionService, private srvParachutiste: ParachutisteService) {
    this.refresh();
   }

   refresh = () => {
    this.avions = this.srvAvion.findAll();
    this.volsPreparation = this.srvVol.findByEtat("PREPARATION");
    this.volsVol = this.srvVol.findByEtat("VOL");
    this.parachutistes = this.srvParachutiste.findAll();
  }

  ngOnInit(): void {
  }

}
