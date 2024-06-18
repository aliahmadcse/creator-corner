import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { getToken } from 'src/app/shared/shared';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  const token = getToken();
  if (token) {
    return true;
  } else {
    router.navigate(['/auth/signin']);
    return false;
  }
};
