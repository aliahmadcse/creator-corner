import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailComponent } from './user-detail/user-detail.component';

@NgModule({
  declarations: [UserDetailComponent],
  imports: [CommonModule],
  exports: [UserDetailComponent],
})
export class UserModule {}
