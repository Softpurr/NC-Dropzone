import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { FlexLayoutModule } from '@angular/flex-layout';
import { VolComponent } from './admin/vol/vol.component';
import { SautComponent } from './admin/saut/saut.component';
import { ParachuteComponent } from './admin/parachute/parachute.component';
import { ParachutisteComponent } from './admin/parachutiste/parachutiste.component';
import { PiloteComponent } from './admin/pilote/pilote.component';
import { AvionComponent } from './admin/avion/avion.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EnregistrementComponent } from './enregistrement/enregistrement.component';
import { PlanningComponent } from './planning/planning.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OuiNonPipe } from './oui-non.pipe';


import { ModalComponent } from './modal/modal.component';
import { BeerlistComponent } from './beerlist/beerlist.component';

@NgModule({
  declarations: [
    AppComponent,
    VolComponent,
    SautComponent,
    ParachuteComponent,
    ParachutisteComponent,
    PiloteComponent,
    AvionComponent,
    HomeComponent,
    EnregistrementComponent,
    PlanningComponent,
    ModalComponent,
    OuiNonPipe,
    BeerlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    // FlexLayoutModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
