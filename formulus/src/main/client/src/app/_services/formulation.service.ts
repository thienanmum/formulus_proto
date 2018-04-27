import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {AppConfig} from "../app.config";
import {Formulation} from "../_model/Formulation";

@Injectable()
export class FormulationService {
  private SERVICE_URI = AppConfig.SERVER_HOST + "api/formulations/";
  constructor(private httpClient: HttpClient) {
  }

  public getAll(): Observable<Formulation[]> {
    return this.httpClient.get<Formulation[]>(this.SERVICE_URI);
  }

  public create(formulation: Formulation): Observable<Formulation> {
    return this.httpClient.post<Formulation>(this.SERVICE_URI, formulation);
  }

  public update(formulation: Formulation): Observable<Formulation> {
    return this.httpClient.put<Formulation>(this.SERVICE_URI + "/" + formulation.id, formulation);
  }

  public delete(formulationId: string): Observable<any> {
    return this.httpClient.delete(this.SERVICE_URI + formulationId);
  }
}
