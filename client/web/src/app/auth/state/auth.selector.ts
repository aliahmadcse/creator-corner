import { createSelector } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import { AuthState } from '../auth.types';


export const authSelector = (state: AppState) => state.auth;;

export const selectAuthResponse = createSelector(
  authSelector,
  (state: AuthState) => state.authResponse
);


export const selectAuthErrorResponse = createSelector(
  authSelector,
  (state: AuthState) => state.authError
);
