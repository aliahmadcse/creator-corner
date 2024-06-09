import { createSelector } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import { JwtResponse } from '../auth.types';


export const authSelector = (state: AppState) => state.auth;;

export const selectAuth = createSelector(
  authSelector,
  (state: JwtResponse) => state
);
