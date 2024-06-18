import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  isAuthenticated: boolean = false;

  ngOnInit() {
    let auth = localStorage.getItem('auth');
    let parsedAuth, token = undefined;
    if (auth) {
      parsedAuth = JSON.parse(auth);
      token = parsedAuth.token;
    }
    if (token) {
      this.isAuthenticated = true;
    } else {
      this.isAuthenticated = false;
    }
  }
  constructor(public router: Router) {}

  logout() {

  }
}
