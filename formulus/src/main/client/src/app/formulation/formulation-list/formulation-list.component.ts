import { Component, OnInit } from '@angular/core';
import {Formulation} from "../../_model/Formulation";
import {FormulationService} from "../../_services/formulation.service";

@Component({
  selector: 'app-formulation-list',
  templateUrl: './formulation-list.component.html',
  styleUrls: ['./formulation-list.component.css']
})
export class FormulationListComponent implements OnInit {
  formulations: Formulation[];
  columnsToDisplay = ['id', 'purpose', 'applicationTechnique', 'target', 'physicalForm', 'actions'];

  constructor(private formulationService: FormulationService) {
    this.formulationService.getAll().subscribe(
      res => this.formulations = res,
      err => console.log(err));
  }

  ngOnInit() {
  }

}
