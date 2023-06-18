import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Player } from './model/player';
import { PlayerInput } from './model/playerInput';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

    private playerSubject: BehaviorSubject<Player | null>;
    private playerInputSubject: BehaviorSubject<PlayerInput | null>;
    public player: Observable<Player | null>;
    public playerInput: Observable<PlayerInput | null>;

  private apiUrl:string = 'http://localhost:8080/api';

  constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.playerSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('player')!));
        this.playerInputSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('playerInput')!));
        this.player = this.playerSubject.asObservable();
        this.playerInput = this.playerInputSubject.asObservable();
    }

  getAll() {
    return this.http.get<Player[]>(`${this.apiUrl}/player`);
  }

  add(playerInput: PlayerInput) {
    return this.http.post(`${this.apiUrl}/player`, playerInput);
  }

}
