import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Repos } from 'src/app/model/repos.model';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  serchUserUrl: string;
  reposUrl: string;

  constructor(private http: HttpClient) {
    this.serchUserUrl = 'https://api.github.com/search/users';
  }

  getApiUser(term: string): Observable<any> {
    // search users with followers > 1 and repos > 2 to save time
    const url = this.serchUserUrl + '?q=' + term + '+repos:>2+followers:>1';
    return this.http.get<any>(url);
  }

  getApiRepos(url: string): Observable<Repos[]> {
    return this.http.get<Repos[]>(url);
  }
}
