import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { authAbsentGuard } from './auth-absent.guard';

describe('authAbsentGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => authAbsentGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
