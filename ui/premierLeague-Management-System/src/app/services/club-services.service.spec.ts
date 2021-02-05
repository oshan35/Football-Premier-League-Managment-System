/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ClubServices } from './club-services.service';

describe('Service: ClubServices', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClubServices]
    });
  });

  it('should ...', inject([ClubServices], (service: ClubServices) => {
    expect(service).toBeTruthy();
  }));
});
