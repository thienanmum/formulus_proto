import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormulationComponent} from "./formulation.component";
import {FormulationListComponent} from "./formulation-list/formulation-list.component";
import {FormulationDetailComponent} from "./formulation-detail/formulation-detail.component";

const routes: Routes = [
  {path:'', component:FormulationComponent,
  children: [
    {path:'list', component:FormulationListComponent},
    {path:'add', component:FormulationDetailComponent},
    {path: 'edit/{:id}', component: FormulationDetailComponent},
    {path: 'delete/{:id}', component: FormulationComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormulationRoutingModule { }
