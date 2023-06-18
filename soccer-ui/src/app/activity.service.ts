import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Activity } from './model/activity';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

    private activitySubject: BehaviorSubject<Activity | null>;
    public activity: Observable<Activity | null>;

  private apiUrl:string = 'http://localhost:8080/api';

  constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.activitySubject = new BehaviorSubject(JSON.parse(localStorage.getItem('activity')!));
        this.activity = this.activitySubject.asObservable();
    }

  getAll() {
    return this.http.get<Activity[]>(`${this.apiUrl}/activity`);
  }

  add(activity: Activity) {
    return this.http.post(`${this.apiUrl}/activity`, activity);
  }

}
