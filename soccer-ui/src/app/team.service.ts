import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Team } from './model/team';
import { TeamInput } from './model/teamInput';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

    private teamSubject: BehaviorSubject<Team | null>;
    private teamInputSubject: BehaviorSubject<TeamInput | null>;
    public team: Observable<Team | null>;
    public teamInput: Observable<TeamInput | null>;

  private apiUrl:string = 'http://localhost:8080/api';

  constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.teamSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('team')!));
        this.teamInputSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('teamInput')!));
        this.team = this.teamSubject.asObservable();
        this.teamInput = this.teamInputSubject.asObservable();
    }

  getAll() {
    return this.http.get<Team[]>(`${this.apiUrl}/team`);
  }

  add(teamInput: TeamInput) {
    return this.http.post(`${this.apiUrl}/team`, teamInput);
  }

}
