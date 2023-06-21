import { createReducer } from '@ngrx/store';

const initialUserState = {
  email: '',
  name: '',
};

export const userReducer = createReducer(initialUserState);
