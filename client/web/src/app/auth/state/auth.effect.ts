import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, exhaustMap, map, of } from 'rxjs';
import { AuthService } from '../auth.service';
import * as AuthActions from '../state/auth.action';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { JwtResponse } from '../auth.types';


@Injectable()
export class AuthEffect {
  constructor(private authService: AuthService, private action$: Actions) { }

  signUp$ = createEffect(() =>
    this.action$.pipe(
      ofType(AuthActions.signUp),
      exhaustMap((action) =>
        this.authService.signUp(action.signUpRequest).pipe(
          map((jwtResponse) => this.handleSignUpSuccess(jwtResponse)),
          catchError((signUpFailure) => of(this.handleSignUpFailure(signUpFailure)))
        )
      )
    )
  );

  private handleSignUpSuccess(response: HttpResponse<JwtResponse>) {
    if (response.status === 200 && response.body) {
      return AuthActions.signUpSuccess({ jwtResponse: response.body });
    }
    return AuthActions.signUpFailure({ signUpFailure: { "message": "Something went wrong" } });
  }

  private handleSignUpFailure(error: HttpErrorResponse) {
    if ((error.status === 409 || error.status === 400) && error.error) {
      return AuthActions.signUpFailure({ signUpFailure: error.error });
    } else {
      return AuthActions.signUpFailure({ signUpFailure: { "message": 'Something went wrong' } });
    }
  }
}
