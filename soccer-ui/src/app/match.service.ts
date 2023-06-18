import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Match } from './model/match';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

    private matchSubject: BehaviorSubject<Match | null>;
    public match: Observable<Match | null>;

  private apiUrl:string = 'http://localhost:8080/api';

  constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.matchSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('match')!));
        this.match = this.matchSubject.asObservable();
    }

  getAll() {
    return this.http.get<Match[]>(`${this.apiUrl}/match`);
  }

  add(match: Match) {
    return this.http.post(`${this.apiUrl}/match`, match);
  }

}
