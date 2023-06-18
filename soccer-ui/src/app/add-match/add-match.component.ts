import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { MatchService } from '../match.service';

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.less']
})
export class AddMatchComponent implements OnInit {
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
      private matchService: MatchService,
      private alertService: AlertService
  ) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.form = this.formBuilder.group({
          gameDate: ['', Validators.required],
          host: ['', Validators.required],
          guest: ['', Validators.required],
          result: ['', Validators.required],
          name: ['', Validators.required]
      });

      this.title = 'Add Match';
  }

  get f() { return this.form.controls; }

  onSubmit() {
      this.submitted = true;

      this.alertService.clear();

      if (this.form.invalid) {
          return;
      }

      this.submitting = true;
      this.saveMatch()
          .pipe(first())
          .subscribe({
              next: () => {
                  this.alertService.success('Match saved', { keepAfterRouteChange: true });
                  this.router.navigateByUrl('/match');
              },
              error: error => {
                  this.alertService.error(error);
                  this.submitting = false;
              }
          })
  }

  private saveMatch() {
      return this.matchService.add(this.form.value);
  }

}
