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
    email: '',
    password: '',
    message: ''
  }
};

export const authReducer = createReducer(
  initialAuthState,
  on(AuthActions.signUpSuccess, (state, { jwtResponse }) => ({ ...state, authResponse: jwtResponse })),
  on(AuthActions.signUpFailure, (state, { signUpFailure }) => ({ ...state, authError: signUpFailure })),
  on(AuthActions.signInSuccess, (state, { jwtResponse }) => ({ ...state, authResponse: jwtResponse })),
  on(AuthActions.signInFailure, (state, { signInFailure }) => ({ ...state, authError: signInFailure })),
  on(AuthActions.clearAuthErrors, (state) => ({ ...state, authError: {} })),
);
