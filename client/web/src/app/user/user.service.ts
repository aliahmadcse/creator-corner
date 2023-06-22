import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from './user.types';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  API_URL = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  getUser() {
    // return this.httpClient.get<T>(this.API_URL + path);
    return this.httpClient.get<User>(
      'https://jsonplaceholder.typicode.com/todos/1'
    );
  }

  post(path: string, body: any) {
    return this.httpClient.post(this.API_URL + path, body);
  }
}
