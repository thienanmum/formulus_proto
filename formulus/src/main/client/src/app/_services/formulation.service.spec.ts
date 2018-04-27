import { TestBed, inject } from '@angular/core/testing';

import { FormulationService } from './formulation.service';

describe('FormulationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormulationService]
    });
  });

  it('should be created', inject([FormulationService], (service: FormulationService) => {
    expect(service).toBeTruthy();
  }));
});
