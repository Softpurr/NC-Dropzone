import { Component, OnInit } from '@angular/core';
import { VolService } from 'src/app/vol.service';

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.css']
})
export class VolComponent implements OnInit {

  vols: any = [];
  formvol: any = {
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
    this.refresh();
  }

  ngOnInit(): void {
  }

  ajouterVol() {
    this.srvVol.add(this.formvol).subscribe(this.refresh);
  }

  editerVol(vol: any) {
    this.formvol = vol;
  }

  modifierVol() {
    this.srvVol.update(this.formvol).subscribe(this.refresh);
    this.formvol = {nombreSaut: 0, avion: null, pilote: null, etat: "",responsable: null,};
  }

  supprimerVol(vol: any) {
    this.srvVol.delete(vol).subscribe(this.refresh);
  }

}