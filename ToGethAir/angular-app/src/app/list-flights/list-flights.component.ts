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

  constructor(
    private flightService: FlightService,
    public dialog: MatDialog
  ) {


  }

  ngOnInit(): void {
    this.flightService.getFlights().subscribe(flights => {
      //this.flightInfo = JSON.stringify(flights);

      this.flights = flights;
      this.filteredFlights = this.flights;

      // flights.forEach(( flight,flightNr) => { // cast json to seatingInfo
      //   // only tested on 1 element; TODO: test with multiple categories
      //   let temp =JSON.stringify(flight.seatingInfo);        // to json
      //   temp = temp.substr(1,temp.length-2);     // remove outer brackets
      //   let temp2 = temp.split(':');                //  split key and value
      //
      //   let seatingInfo = new SeatingInfo();
      //   seatingInfo.ticketTypes.push(temp2[0].substr(1,temp2[0].length-2));
      //
      //   seatingInfo.availableSeats.push(parseInt(temp2[1]));
      //   this.flights[flightNr].seatingInfo = seatingInfo;
      // })
    });
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
      data: {flight: flight, tekstje: "hoi"}
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
      // flights.forEach(( flight,flightNr) => {
      //
      //   // only tested on 1 element; TODO: test with multiple categories
      //   let temp =JSON.stringify(flight.seatingInfo);        // to json
      //   temp = temp.substr(1,temp.length-2);     // remove outer brackets
      //   let temp2 = temp.split(':');                //  split key and value
      //
      //   let seatingInfo = new SeatingInfo();
      //   seatingInfo.ticketTypes.push(temp2[0]);
      //   seatingInfo.availableSeats.push(parseInt(temp2[1]));
      //   this.flights[flightNr].seatingInfo = seatingInfo;
      // })
    });
  }

  public getTotalSeats(flight: Flight): number{
    let count = 0;
    console.log(flight);
    //console.log(flight.seatingInfo.get("buissness"));
    for (let entry of flight.seatingInfo.entries()) {
      count += entry[1];
    }
    // flight.seatingInfo.forEach(value => {count += value;})
    return count;
  }

}
