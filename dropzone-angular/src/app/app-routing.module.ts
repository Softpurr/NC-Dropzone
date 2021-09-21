import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

const routes: Routes = [/*
  { path: '', component: HomeComponent },
  { path: 'enregistrement', component: EnregistrementComponent },
  { path: 'planning', component: PlanningComponent },
  { path: 'connexion', component: ConnexionComponent },*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
