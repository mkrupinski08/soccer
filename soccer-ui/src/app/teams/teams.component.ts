import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { TeamService } from '../team.service';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.less']
})
export class TeamsComponent implements OnInit {
  teams?: any[];

  constructor(private teamService: TeamService) {}

  ngOnInit() {
    this.teamService.getAll()
      .pipe(first())
      .subscribe(teams => this.teams = teams);
  }

}
