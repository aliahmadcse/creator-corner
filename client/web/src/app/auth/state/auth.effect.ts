import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, exhaustMap, map, mergeMap, of } from 'rxjs';
import { AuthService } from '../auth.service';
import * as AuthActions from '../state/auth.action';


@Injectable()
export class AuthEffect {
  constructor(private authService: AuthService, private action$: Actions) { }

  signUp$ = createEffect(() =>
    this.action$.pipe(
      ofType(AuthActions.signUp),
      exhaustMap((action) =>
        this.authService.signUp(action.signUpRequest).pipe(
          map((jwtResponse) => AuthActions.signUpSuccess({ jwtResponse })),
          catchError((signUpFailure) => of(AuthActions.signUpFailure({ signUpFailure })))
        )
      )
    )
  );
}
