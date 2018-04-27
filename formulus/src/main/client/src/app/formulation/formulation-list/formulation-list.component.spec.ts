import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulationListComponent } from './formulation-list.component';

describe('FormulationListComponent', () => {
  let component: FormulationListComponent;
  let fixture: ComponentFixture<FormulationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
