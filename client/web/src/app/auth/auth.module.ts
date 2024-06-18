import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { EffectsModule } from '@ngrx/effects';
import { AuthEffect } from './state/auth.effect';
import { authAbsentGuard } from './guard/auth-absent.guard';

const routes: Routes = [
  {
    path: "signup",
    component: SignupComponent,
    canActivate: [authAbsentGuard]
  },
  {
    path: "signin",
    component: SigninComponent,
    canActivate: [authAbsentGuard]
  }
];


@NgModule({
  declarations: [
    SignupComponent,
    SigninComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(routes),
    EffectsModule.forFeature([AuthEffect])
  ]
})
export class AuthModule { }
