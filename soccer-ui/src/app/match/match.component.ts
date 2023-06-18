import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { MatchService } from '../match.service';

@Component({ templateUrl: './match.component.html' })
export class MatchComponent implements OnInit {
  match?: any[];

  constructor(private matchService: MatchService) {}

  ngOnInit() {
    this.matchService.getAll()
      .pipe(first())
      .subscribe(match => this.match = match);
  }

}
