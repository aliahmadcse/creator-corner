import { createReducer, on } from '@ngrx/store';
import { User, UserState } from '../user.types';
import { userPageActions } from './user.action';

const initialUserState: UserState = {
  user: {
    id: 0,
    email: '',
    firstName: '',
    lastName: '',
    headline: '',
    bio: '',
    createdOn: '',
    role: {
      id: 0,
      name: '',
      createdOn: '',
    }
  }
};

export const userReducer = createReducer(
  initialUserState,
  on(userPageActions.getUserSuccess, (state, { user }) => ({ ...state, user }))
);
