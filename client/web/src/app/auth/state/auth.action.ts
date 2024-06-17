import { createAction, props } from '@ngrx/store';
import { JwtResponse, SignUpRequest } from '../auth.types';

// sign up actions
export const signUp = createAction('[Auth] Sign Up', props<{ signUpRequest: SignUpRequest; }>());
export const signUpSuccess = createAction('[Auth] Sign Up Success', props<{ jwtResponse: JwtResponse; }>());
export const signUpFailure = createAction('[Auth] Sign Up Failure', props<{ signUpFailure: {}; }>());

