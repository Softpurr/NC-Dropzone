import { TestBed } from '@angular/core/testing';

import { BeerlistService } from './beerlist.service';

describe('BeerlistService', () => {
  let service: BeerlistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BeerlistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
