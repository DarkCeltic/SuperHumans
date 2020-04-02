import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperHumanComponent } from './super-human.component';

describe('SuperHumanComponent', () => {
  let component: SuperHumanComponent;
  let fixture: ComponentFixture<SuperHumanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperHumanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperHumanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
