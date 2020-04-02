import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperHumanDashboardComponent } from './super-human-dashboard.component';

describe('SuperHumanDashboardComponent', () => {
  let component: SuperHumanDashboardComponent;
  let fixture: ComponentFixture<SuperHumanDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperHumanDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperHumanDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
