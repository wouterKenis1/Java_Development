import {Component, EventEmitter, OnInit} from '@angular/core';
import {DatePipe} from '@angular/common';
import {FlightService} from '../services/flight.service';
import {Flight} from '../models/Flight';
import {BookingComponent} from '../booking/booking.component';
import {MatDialog} from '@angular/material/dialog';
import {AddClassComponent} from './add-class/add-class.component';
import {PricingInfo} from '../models/PricingInfo';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flight: Flight = new Flight();
  //refreshFlights:EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(
    public dialog: MatDialog,
    public flightService: FlightService
  ) { }

  ngOnInit(): void {
  }

  public submit(){
    console.log("submit flight: ");
    // this.logFlight();
    this.flightService.createFlight(this.flight).subscribe(result => console.log(result));
  }

  public openDialog(): void {
    const dialogRef = this.dialog.open(AddClassComponent,{
      // width: '250px',
      data: this.flight
    });

    dialogRef.afterClosed().subscribe(result =>{
      // console.log("closed. logging this.flight | result"); // input the result into the flight
      // console.log(this.flight);
      // console.log(result);
    })
  }

  public logFlight(): boolean{
    console.log(this.flight);
    return false;
  }
}
