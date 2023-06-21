import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  API_URL = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  get(path: string) {
    return this.httpClient.get(this.API_URL + path);
  }

  post(path: string, body: any) {
    return this.httpClient.post(this.API_URL + path, body);
  }
}
