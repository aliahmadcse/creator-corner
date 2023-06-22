import { createReducer, on } from '@ngrx/store';
import { User } from '../user.types';
import { userPageActions } from './user.action';

const initialUserState: User = {
  email: '',
  name: '',
};

export const userReducer = createReducer(
  initialUserState,
  on(userPageActions.getUserSuccess, (state, { user }) => user)
);
