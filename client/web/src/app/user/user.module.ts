import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { EffectsModule } from '@ngrx/effects';
import { UserEffect } from './state/user.effect';

@NgModule({
  declarations: [UserDetailComponent],
  imports: [
    CommonModule,
    EffectsModule.forFeature([UserEffect]),
  ],
  exports: [UserDetailComponent],
})
export class UserModule {}
