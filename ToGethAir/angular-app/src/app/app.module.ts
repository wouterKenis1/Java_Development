import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListLocationsComponent } from './list-locations/list-locations.component';
import { HttpClientModule } from '@angular/common/http';
import { ListFlightsComponent } from './list-flights/list-flights.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LoginComponent } from './login/login.component';

import { MatSliderModule } from '@angular/material/slider';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { BookingComponent } from './booking/booking.component';
import { PayComponent } from './pay/pay.component';
import { AddLocationComponent } from './add-location/add-location.component';
import { AddFlightComponent } from './add-flight/add-flight.component';

@NgModule({
    declarations: [
        AppComponent,
        ListLocationsComponent,
        ListFlightsComponent,
        LoginComponent,
        BookingComponent,
        PayComponent,
        AddLocationComponent,
        AddFlightComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatTabsModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
