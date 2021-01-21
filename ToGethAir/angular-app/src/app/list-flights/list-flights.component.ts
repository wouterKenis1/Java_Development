import {Component, Input, OnInit} from '@angular/core';
import {Flight} from '../models/Flight';
import {DatePipe} from '@angular/common';
import {FlightService} from '../services/flight.service';
import {SeatingInfo} from '../models/SeatingInfo';
import {MatDialog} from '@angular/material/dialog';
import {LoginComponent} from '../login/login.component';
import {BookingComponent} from '../booking/booking.component';

@Component({
  selector: 'app-list-flights-employee',
  templateUrl: './list-flights.component.html',
  styleUrls: ['./list-flights.component.css']
})
export class ListFlightsComponent implements OnInit {

  flights: Flight[];
  filteredFlights: Flight[];
  flightInfo: string;

  @Input() title: string[];
  @Input() username: string;

  constructor(
    private flightService: FlightService,
    public dialog: MatDialog
  ) {


  }

  ngOnInit(): void {
    this.updateFlights();
  }


  filterAirline(searchtext: string): void{
    this.flights.forEach(flight =>{
      this.filteredFlights = [];
      if(flight.airline.toLowerCase().startsWith(searchtext.toLowerCase())){
        this.filteredFlights.push(flight);
      }
    });
    console.log(this.filteredFlights);
  }

  public printTitles(){
    console.log(this.title);
  }

  public openDialog(flight:Flight): void {
    console.log(flight);
    const dialogRef = this.dialog.open(BookingComponent,{
      // width: '250px',
      data: {flight: flight, username: this.username}
    });

    dialogRef.afterClosed().subscribe(result =>{
        this.updateFlights();
    })
  }

  updateFlights(){
    this.flightService.getFlights().subscribe(flights => {
      this.flightInfo = JSON.stringify(flights);
      this.flights = flights;
      this.filteredFlights = this.flights;

    });
  }
}
