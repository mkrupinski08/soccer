import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './_helpers';

const accountModule = () => import('./account/account.module').then(x => x.AccountModule);
const playersModule = () => import('./players/players.module').then(x => x.PlayersModule);
const teamsModule = () => import('./teams/teams.module').then(x => x.TeamsModule);
const matchModule = () => import('./match/match.module').then(x => x.MatchModule);
const activityModule = () => import('./home/activity.module').then(x => x.ActivityModule);

const routes: Routes = [
    { path: '', loadChildren: activityModule, canActivate: [AuthGuard] },
    { path: 'account', loadChildren: accountModule },
    { path: 'players', loadChildren: playersModule, canActivate: [AuthGuard]  },
    { path: 'teams', loadChildren: teamsModule, canActivate: [AuthGuard]  },
    { path: 'match', loadChildren: matchModule, canActivate: [AuthGuard]  },
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
