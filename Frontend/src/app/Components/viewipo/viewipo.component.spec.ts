import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewIpoComponent } from './viewipo.component';

describe('ViewIpoComponent', () => {
  let component: ViewIpoComponent;
  let fixture: ComponentFixture<ViewIpoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewIpoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewIpoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
