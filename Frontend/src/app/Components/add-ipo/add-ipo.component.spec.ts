import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIpoComponent } from './add-ipo.component';

describe('AddIpoComponent', () => {
  let component: AddIpoComponent;
  let fixture: ComponentFixture<AddIpoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddIpoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIpoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
