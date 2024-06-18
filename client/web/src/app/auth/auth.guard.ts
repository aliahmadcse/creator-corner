import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtResponse } from './auth.types';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  let auth = localStorage.getItem('auth');
  let parsedAuth, token = undefined;
  if (auth) {
    parsedAuth = JSON.parse(auth);
    token = parsedAuth.token;
  }
  if (token) {
    return true;
  } else {
    router.navigate(['/auth/signin']);
    return false;
  }
};
