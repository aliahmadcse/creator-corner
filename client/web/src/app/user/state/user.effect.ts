import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { HttpService } from 'src/app/service/http/http.service';
import { userPageActions } from './user.action';
import { catchError, exhaustMap, map, mergeMap, of } from 'rxjs';
import { User } from '../user.types';

@Injectable()
export class UserEffect {
  constructor(private httpService: HttpService, private action$: Actions) {}

  getUser$ = createEffect(() =>
    this.action$.pipe(
      ofType(userPageActions.getUser),
      exhaustMap(() =>
        this.httpService.get<User>('/user').pipe(
          map((user) => userPageActions.getUserSuccess({ user })),
          catchError((error) => of(userPageActions.getUserFailure({ error })))
        )
      )
    )
  );
}
