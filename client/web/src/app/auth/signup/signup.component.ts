import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  userEmail: string = '';
  userPassword: string = '';
  emailInvalid: boolean = false;
  passwordInvalid: boolean = false;


  constructor() { }

  ngOnInit(): void {
  }


  onSubmit() {
    console.log('submitted');
  }
}
