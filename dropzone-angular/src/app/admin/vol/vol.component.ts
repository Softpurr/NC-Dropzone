import { Component, OnInit } from '@angular/core';
import { VolService } from 'src/app/vol.service';

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.css']
})
export class VolComponent implements OnInit {

  vols: any = [];
  volForm: any = {
    nombreSaut: 0,
    avion: null,
    pilote: null,
    etat: "",
    responsable: null,
  };

  refresh = () => {
    this.vols = this.srvVol.findAll();
  }

  constructor(private srvVol: VolService) {
    this.vols = this.srvVol.findAll();
  }

  ngOnInit(): void {
  }

  ajouterVol() {
    this.srvVol.add(this.volForm).subscribe(this.refresh);
  }

  editerVol(vol: any) {
    this.volForm = vol;
  }

  modifierVol() {
    this.srvVol.update(this.volForm).subscribe(this.refresh);
  }

  supprimerVol(vol: any) {
    this.srvVol.delete(vol).subscribe(this.refresh);
  }

}