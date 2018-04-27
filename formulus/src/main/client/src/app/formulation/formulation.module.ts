import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormulationRoutingModule } from './formulation-routing.module';
import {FormulationListComponent} from "./formulation-list/formulation-list.component";
import {FormulationDetailComponent} from "./formulation-detail/formulation-detail.component";
import {MatTableModule} from "@angular/material";
import {FormulationService} from "../_services/formulation.service";
import {FormulationComponent} from "./formulation.component";

@NgModule({
  imports: [
    CommonModule,
    FormulationRoutingModule,
    MatTableModule
  ],
  declarations: [
    FormulationListComponent,
    FormulationDetailComponent,
    FormulationComponent
  ],
  exports: [
    FormulationRoutingModule,
    MatTableModule,
    FormulationComponent
  ],
  providers: [FormulationService],
})
export class FormulationModule { }
