import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessAdminComponent } from './success-admin.component';

describe('SuccessAdminComponent', () => {
  let component: SuccessAdminComponent;
  let fixture: ComponentFixture<SuccessAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuccessAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
