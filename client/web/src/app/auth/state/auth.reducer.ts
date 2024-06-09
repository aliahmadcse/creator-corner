import { createReducer, on } from '@ngrx/store';
import { JwtResponse } from '../auth.types';
import * as AuthActions from './auth.action';


export const initialAuthState: JwtResponse = {
  email: '',
  token: '',
  role: ''
};

export const authReducer = createReducer(
  initialAuthState,
  on(AuthActions.signUpSuccess, (state, jwtResponse) => ({ ...state, jwtResponse }))
);
