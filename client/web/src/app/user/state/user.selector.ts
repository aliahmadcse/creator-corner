import { createSelector } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import { UserState } from '../user.types';

export const userSelector = (state: AppState) => state.user;

export const selectUserResponse = createSelector(
  userSelector,
  (state: UserState) => state.user
);

