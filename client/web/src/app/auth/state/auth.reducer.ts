import { createReducer, on } from '@ngrx/store';
import { AuthState } from '../auth.types';
import * as AuthActions from './auth.action';



export const initialAuthState: AuthState = {
  authResponse: {
    email: '',
    token: '',
    role: ''
  },
  authError: {
    error: {}
  }
};

export const authReducer = createReducer(
  initialAuthState,
  on(AuthActions.signUpSuccess, (state, { jwtResponse }) => ({ ...state, authResponse: jwtResponse })),
  on(AuthActions.signUpFailure, (state, { signUpFailure }) => ({ ...state, authError: signUpFailure }))
);
