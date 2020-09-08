import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExchangeDetailsComponent } from './exchange-details.component';

describe('ExchangeDetailsComponent', () => {
  let component: ExchangeDetailsComponent;
  let fixture: ComponentFixture<ExchangeDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExchangeDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExchangeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
