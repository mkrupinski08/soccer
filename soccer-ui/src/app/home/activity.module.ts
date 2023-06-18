import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { ActivityRoutingModule } from './activity-routing.module';
import { LayoutComponent } from './layout.component';
import { HomeComponent } from './home.component';
import { AddActivityComponent } from '../add-activity/add-activity.component';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        ActivityRoutingModule
    ],
    declarations: [
        LayoutComponent,
        HomeComponent,
        AddActivityComponent
    ]
})
export class ActivityModule { }
