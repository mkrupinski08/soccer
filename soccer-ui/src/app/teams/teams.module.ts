import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { TeamsRoutingModule } from './teams-routing.module';
import { LayoutComponent } from './layout.component';
import { TeamsComponent } from './teams.component';
import { AddTeamComponent } from '../add-team/add-team.component';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        TeamsRoutingModule
    ],
    declarations: [
        LayoutComponent,
        TeamsComponent,
        AddTeamComponent
    ]
})
export class TeamsModule { }
