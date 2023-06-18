import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-add-team',
  templateUrl: './add-team.component.html',
  styleUrls: ['./add-team.component.less']
})
export class AddTeamComponent implements OnInit {
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
      private teamService: TeamService,
      private alertService: AlertService
  ) { }

  ngOnInit() {
      this.id = this.route.snapshot.params['id'];

      this.form = this.formBuilder.group({
          name: ['', Validators.required],
          foundationDate: ['', Validators.required]
      });

      this.title = 'Add Team';
  }

  get f() { return this.form.controls; }

  onSubmit() {
      this.submitted = true;

      this.alertService.clear();

      if (this.form.invalid) {
          return;
      }

      this.submitting = true;
      this.saveTeam()
          .pipe(first())
          .subscribe({
              next: () => {
                  this.alertService.success('Team saved', { keepAfterRouteChange: true });
                  this.router.navigateByUrl('/teams');
              },
              error: error => {
                  this.alertService.error(error);
                  this.submitting = false;
              }
          })
  }

  private saveTeam() {
      return this.teamService.add(this.form.value);
  }

}
