import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtResponse, SignUpRequest } from './auth.types';
import { HttpService } from '../service/http/http.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpService: HttpService) { }

  signUp(signUpRequest: SignUpRequest): Observable<HttpResponse<JwtResponse>> {
    return this.httpService.post('/auth/signup', signUpRequest);
  }
}
