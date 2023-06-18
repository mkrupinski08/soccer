import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { ActivityService } from '../activity.service';

@Component({
  selector: 'app-add-activity',
  templateUrl: './add-activity.component.html',
  styleUrls: ['./add-activity.component.less']
})
export class AddActivityComponent implements OnInit {
  form!: FormGroup;
  id?: string;
  title!: string;
  loading = false;
  submitting = false;
  submitted = false;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private activityService: ActivityService,
      private alertService: AlertService
  ) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.form = this.formBuilder.group({
          timestamp: ['', Validators.required],
          activityType: ['', Validators.required],
          player: ['', Validators.required],
          match: ['', Validators.required]
      });

      this.title = 'Add Activity';
  }

  get f() { return this.form.controls; }

  onSubmit() {
      this.submitted = true;

      this.alertService.clear();

      if (this.form.invalid) {
          return;
      }

      this.submitting = true;
      this.saveActivity()
          .pipe(first())
          .subscribe({
              next: () => {
                  this.alertService.success('Activity saved', { keepAfterRouteChange: true });
                  this.router.navigateByUrl('');
              },
              error: error => {
                  this.alertService.error(error);
                  this.submitting = false;
              }
          })
  }

  private saveActivity() {
      return this.activityService.add(this.form.value);
  }

}
