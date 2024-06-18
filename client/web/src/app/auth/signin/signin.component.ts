import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthErrorResponse } from '../auth.types';
import { Subscription } from 'rxjs';
import { Store, select } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import { Router } from '@angular/router';
import * as AuthActions from '../state/auth.action';
import { selectAuthErrorResponse, selectAuthResponse } from '../state/auth.selector';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit, OnDestroy {
  signInRequest = {
    email: '',
    password: '',
  };
  error: AuthErrorResponse = {
    email: '',
    password: '',
    message: '',
  };
  subscription = new Subscription();

  constructor(private store: Store<AppState>, private router: Router) { }

  ngOnInit(): void {
  }


  onSubmit() {
    this.store.dispatch(AuthActions.clearAuthErrors());
    this.store.dispatch(AuthActions.signIn({ signInRequest: { ...this.signInRequest } }));

    this.subscription.add(this.store.pipe(select(selectAuthResponse))
      .subscribe((data) => {
        if (data.token) {
          localStorage.setItem('auth', JSON.stringify(data));
          this.router.navigate(['/user-details']);
        }
      })
    );

    this.subscription.add(this.store.pipe(select(selectAuthErrorResponse)).subscribe((data) => {
      this.error = data;
    }));
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
