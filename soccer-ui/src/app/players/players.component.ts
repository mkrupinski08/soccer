import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { PlayerService } from '../player.service';

@Component({ templateUrl: './players.component.html' })
export class PlayersComponent implements OnInit {
  players?: any[];

  constructor(private playerService: PlayerService) {}

  ngOnInit() {
    this.playerService.getAll()
      .pipe(first())
      .subscribe(players => this.players = players);
  }

}
