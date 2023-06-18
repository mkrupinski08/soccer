import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { PlayersRoutingModule } from './players-routing.module';
import { LayoutComponent } from './layout.component';
import { PlayersComponent } from './players.component';
import { AddPlayerComponent } from '../add-player/add-player.component';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        PlayersRoutingModule
    ],
    declarations: [
        LayoutComponent,
        PlayersComponent,
        AddPlayerComponent
    ]
})
export class PlayersModule { }
