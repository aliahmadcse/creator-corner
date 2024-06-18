import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Store, select } from '@ngrx/store';
import { selectAuthResponse } from 'src/app/auth/state/auth.selector';
import { HttpService } from 'src/app/service/http/http.service';
import { getToken } from 'src/app/shared/shared';
import { AppState } from 'src/app/state/app.state';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  authenticated: boolean = false;

  ngOnInit() {

    this.store.pipe(select(selectAuthResponse)).subscribe(data => {
      const token = getToken();
      if (token || data.token) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
    });
  }

  constructor(private store: Store<AppState>, private router: Router, private httpService: HttpService) { }

  logout() {
    this.httpService.get("/auth/logout").subscribe(response => {
      if (response.status === 200) {
        localStorage.removeItem('auth');
        this.authenticated = false;
        this.router.navigate(['/auth/signin']);
      }
    });
  }
}
