import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { EffectsModule } from '@ngrx/effects';
import { UserEffect } from './state/user.effect';
import { RouterModule, Routes } from '@angular/router';
import { authGuard } from '../auth/guard/auth.guard';


const routes: Routes = [
  {
    path: "user-detail",
    component: UserDetailComponent,
    canActivate: [authGuard],
  }
];


@NgModule({
  declarations: [UserDetailComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    EffectsModule.forFeature([UserEffect]),
  ],
  exports: [UserDetailComponent],
})
export class UserModule {}
