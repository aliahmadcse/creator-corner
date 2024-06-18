import { Component, OnDestroy, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import * as AuthActions from '../state/auth.action';
import { selectAuthErrorResponse, selectAuthResponse } from '../state/auth.selector';
import { Subscription } from 'rxjs';
import { AuthErrorResponse } from '../auth.types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit, OnDestroy {
  signUpRequest = {
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
    this.store.dispatch(AuthActions.clearSignUpErrors());
    this.store.dispatch(AuthActions.signUp({ signUpRequest: { ...this.signUpRequest } }));

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
