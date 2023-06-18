import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { MatchRoutingModule } from './match-routing.module';
import { LayoutComponent } from './layout.component';
import { MatchComponent } from './match.component';
import { AddMatchComponent } from '../add-match/add-match.component';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        MatchRoutingModule
    ],
    declarations: [
        LayoutComponent,
        MatchComponent,
        AddMatchComponent
    ]
})
export class MatchModule { }
