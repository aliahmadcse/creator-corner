import { Component, OnDestroy, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import * as AuthActions from '../state/auth.action';
import { selectAuthErrorResponse, selectAuthResponse } from '../state/auth.selector';
import { Subscription } from 'rxjs';

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
  emailInvalid: boolean = false;
  passwordInvalid: boolean = false;
  subscription = new Subscription();

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
  }


  onSubmit() {
    if (this.signUpRequest.email && this.signUpRequest.password) {
      this.store.dispatch(AuthActions.signUp({ signUpRequest: this.signUpRequest }));
    }

    this.subscription.add(this.store.pipe(select(selectAuthResponse))
      .subscribe((data) => {
        console.log(data);
      })
    );

    this.store.pipe(select(selectAuthErrorResponse)).subscribe((data) => {
      console.log(data);
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
