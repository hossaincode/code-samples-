import { TestBed } from '@angular/core/testing';

import { TestConnectionService } from './test-connection.service';

describe('TestConnectionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TestConnectionService = TestBed.get(TestConnectionService);
    expect(service).toBeTruthy();
  });
});
