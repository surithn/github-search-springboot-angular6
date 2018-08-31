import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  user: User[];
  saveUserUrl: string;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
  constructor(private http: HttpClient) {
    this.saveUserUrl = 'save-usr';
  }


  saveUser(user: User): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.post<User>(this.saveUserUrl, body, this.httpOptions);
  }
}
