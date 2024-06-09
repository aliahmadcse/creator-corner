import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from 'src/app/state/app.state';
import * as AuthActions from '../state/auth.action';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  signUpRequest = {
    email: '',
    password: '',
  };
  emailInvalid: boolean = false;
  passwordInvalid: boolean = false;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
  }


  onSubmit() {
    if (this.signUpRequest.email && this.signUpRequest.password) {
      this.store.dispatch(AuthActions.signUp({ signUpRequest: this.signUpRequest }));
    }
  }
}
