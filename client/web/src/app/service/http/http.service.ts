import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  API_URL = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  get<T>(path: string) {
    // return this.httpClient.get<T>(this.API_URL + path);
    return this.httpClient.get<T>(
      'https://jsonplaceholder.typicode.com/todos/1'
    );
  }

  post(path: string, body: any) {
    return this.httpClient.post(this.API_URL + path, body);
  }
}
