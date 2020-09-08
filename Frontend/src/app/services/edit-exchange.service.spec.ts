import { TestBed } from '@angular/core/testing';

import { EditExchangeService } from './edit-exchange.service';

describe('EditExchangeService', () => {
  let service: EditExchangeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditExchangeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
