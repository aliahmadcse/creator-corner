import { Injectable } from '@angular/core';
import { User } from './user.types';
import { HttpService } from '../service/http/http.service';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private httpService: HttpService) { }

  getUserByEmail(email: string): Observable<HttpResponse<User>> {
    return this.httpService.get<User>(`/users/email/${email}`);
  }
}
