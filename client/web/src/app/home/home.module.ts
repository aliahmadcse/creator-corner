import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { FrontierComponent } from './frontier/frontier.component';



@NgModule({
  declarations: [
    NavbarComponent,
    FrontierComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    NavbarComponent
  ]
})
export class HomeModule { }
