import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulationDetailComponent } from './formulation-detail.component';

describe('FormulationDetailComponent', () => {
  let component: FormulationDetailComponent;
  let fixture: ComponentFixture<FormulationDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulationDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulationDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
