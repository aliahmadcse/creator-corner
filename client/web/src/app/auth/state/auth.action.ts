import { createAction, emptyProps, props } from '@ngrx/store';
import { AuthErrorResponse, JwtResponse, SignInRequest, SignUpRequest } from '../auth.types';

// sign up actions
export const signUp = createAction('[Auth] Sign Up', props<{ signUpRequest: SignUpRequest; }>());
export const signUpSuccess = createAction('[Auth] Sign Up Success', props<{ jwtResponse: JwtResponse; }>());
export const signUpFailure = createAction('[Auth] Sign Up Failure', props<{ signUpFailure: AuthErrorResponse; }>());

// sign in actions
export const signIn = createAction('[Auth] Sign In', props<{ signInRequest: SignInRequest; }>());
export const signInSuccess = createAction('[Auth] Sign In Success', props<{ jwtResponse: JwtResponse; }>());
export const signInFailure = createAction('[Auth] Sign In Failure', props<{ signInFailure: AuthErrorResponse; }>());


export const clearAuthErrors = createAction('[Auth] Clear Sign Up Errors');
