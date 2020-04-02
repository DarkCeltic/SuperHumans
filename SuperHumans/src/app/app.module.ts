import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SuperHumanDashboardComponent } from './components/super-human-dashboard/super-human-dashboard.component';
import { SuperHumanComponent } from './models/super-human/super-human.component';

@NgModule({
  declarations: [
    AppComponent,
    SuperHumanDashboardComponent,
    SuperHumanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
