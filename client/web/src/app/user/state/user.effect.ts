import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { HttpService } from 'src/app/service/http/http.service';
import { userPageActions } from './user.action';
import { catchError, exhaustMap, map, mergeMap, of } from 'rxjs';
import { User } from '../user.types';
import { UserService } from '../user.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Injectable()
export class UserEffect {
  constructor(private userService: UserService, private action$: Actions) { }

  getUser$ = createEffect(() =>
    this.action$.pipe(
      ofType(userPageActions.getUserByEmail),
      exhaustMap((action) =>
        this.userService.getUserByEmail(action.email).pipe(
          map((user) => this.handleUserSuccess(user)),
          catchError((error) => of(this.handleUserFailure(error)))
        )
      )
    )
  );

  private handleUserSuccess(response: HttpResponse<User>) {
    if (response.status === 200 && response.body) {
      return userPageActions.getUserSuccess({ user: response.body });
    }
    return userPageActions.getUserFailure({
      error: { "message": 'Something went wrong' }
    });
  }

  private handleUserFailure(error: HttpErrorResponse) {
    if (error.status === 403 && error.error) {
      return userPageActions.getUserFailure({ error: error.error });
    } else {
      return userPageActions.getUserFailure({ error: { "message": 'Something went wrong' } });
    }
  }


}
