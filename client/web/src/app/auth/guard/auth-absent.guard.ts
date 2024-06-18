import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { getToken } from 'src/app/shared/shared';

export const authAbsentGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  const token = getToken();
  if (token) {
    router.navigate(['/user-details']);
    return false;
  } else {
    return true;
  }
};
