import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '@app/_services';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.less']
})
export class AddPlayerComponent implements OnInit {
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
        private playerService: PlayerService,
        private alertService: AlertService
    ) { }

    ngOnInit() {
        this.id = this.route.snapshot.params['id'];

        this.form = this.formBuilder.group({
            name: ['', Validators.required],
            surname: ['', Validators.required],
            position: ['', Validators.required],
            num: ['', Validators.required],
            birthDate: ['', Validators.required],
            height: ['', Validators.required],
            weight: ['', Validators.required],
            team: ['', Validators.required]
        });

        this.title = 'Add Player';
    }

    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        this.alertService.clear();

        if (this.form.invalid) {
            return;
        }

        this.submitting = true;
        this.savePlayer()
            .pipe(first())
            .subscribe({
                next: () => {
                    this.alertService.success('Player saved', { keepAfterRouteChange: true });
                    this.router.navigateByUrl('/players');
                },
                error: error => {
                    this.alertService.error(error);
                    this.submitting = false;
                }
            })
    }

    private savePlayer() {
        return this.playerService.add(this.form.value);
    }

}
