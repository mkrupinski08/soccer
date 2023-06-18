import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { ActivityService } from '../activity.service';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
  activities?: any[];

  constructor(private activityService: ActivityService) {}

  ngOnInit() {
    this.activityService.getAll()
      .pipe(first())
      .subscribe(activities => this.activities = activities);
  }

}
