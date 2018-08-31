import { Component, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, Subject } from 'rxjs';
import { SearchService } from 'src/app/search/search.service';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { isNullOrUndefined } from 'util';
import { User } from 'src/app/model/user.model';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  searchInput: string;
  searchTerm$ = new Subject<string>();
  constructor(private service: SearchService, private appService: AppService) {
    this.searchTerm$.pipe(
      debounceTime(1000),
      distinctUntilChanged(),
      switchMap((data: string) => this.service.getApiUser(data)))
      .subscribe((data) => {
        this.appService.user = data.items;
        this.getRepos();
      });
  }

  getUser(term: any): void {
    if (!isNullOrUndefined(term) && term.trim().length > 2) {
      this.searchTerm$.next(term.trim());
    }
  }

  getRepos(): void {
    for (const usr of this.appService.user) {
      this.service.getApiRepos(usr.repos_url)
        .subscribe(
        (data) => {
          usr.repos = data;
          this.appService.saveUser(usr).subscribe(
            (res) => console.log(res),
            (err) => alert('save unsuccessful err:' + err.status)
          );
        }
        );
    }
  }
}
