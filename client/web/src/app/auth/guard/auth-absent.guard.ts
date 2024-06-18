import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authAbsentGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);

  let auth = localStorage.getItem('auth');
  let parsedAuth, token = undefined;
  if (auth) {
    parsedAuth = JSON.parse(auth);
    token = parsedAuth.token;
  }
  if (token) {
    router.navigate(['/user-details']);
    return false;
  } else {
    return true;
  }
};
