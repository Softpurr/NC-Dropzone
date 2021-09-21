import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvionComponent } from './admin/avion/avion.component';
import { ParachuteComponent } from './admin/parachute/parachute.component';
import { ParachutisteComponent } from './admin/parachutiste/parachutiste.component';
import { PiloteComponent } from './admin/pilote/pilote.component';
import { SautComponent } from './admin/saut/saut.component';
import { VolComponent } from './admin/vol/vol.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'avion', component: AvionComponent },
  { path: 'parachute', component: ParachuteComponent },
  { path: 'parachutiste', component: ParachutisteComponent },
  { path: 'pilote', component: PiloteComponent },
  { path: 'saut', component: SautComponent },
  { path: 'vol', component: VolComponent },
  // { path: '', component: HomeComponent },
  // { path: 'enregistrement', component: EnregistrementComponent },
  // { path: 'planning', component: PlanningComponent },
  // { path: 'connexion', component: ConnexionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
