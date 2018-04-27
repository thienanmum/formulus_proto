import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
// import {FormulationModule} from "./formulation/formulation.module";
import {HttpClientModule} from "@angular/common/http";
import {MatToolbarModule} from "@angular/material";
import {AppRoutingModule} from "./app-routing";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    // FormulationModule,
    HttpClientModule,
    MatToolbarModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
