import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ClubsComponent} from "./clubs/clubs.component";
import {MatchComponent} from "./match/match.component";


const routes: Routes = [
  {path: "",component:ClubsComponent},
  {path: "match",component:MatchComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
