import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatToolbarModule} from "@angular/material/toolbar";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClubsComponent } from './clubs/clubs.component';
import { MatchComponent } from './match/match.component';
import {ClubServices} from './services/club-services.service';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    AppComponent,
    ClubsComponent,
    MatchComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  providers: [
    ClubServices,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
