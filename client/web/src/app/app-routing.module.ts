import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './home/navbar/navbar.component';
import { UserDetailComponent } from './user/user-detail/user-detail.component';

const routes: Routes = [
  {
    path: '',
    component: NavbarComponent,
  },
  {
    path: "user-details",
    component: UserDetailComponent,
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
