import {Component, EventEmitter, OnInit} from '@angular/core';
import {DatePipe} from '@angular/common';
import {FlightService} from '../services/flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  refreshFlights:EventEmitter<boolean> = new EventEmitter<boolean>();
  constructor(public flightService: FlightService) { }

  ngOnInit(): void {
  }

  public submit(airline: string,from: number,to: number,
  departure:DatePipe,duration:number){
    // console.log(airline);
    // console.log(from);
    // console.log(to);
    // console.log(departure);
    // console.log(duration);

    this.flightService.addFlight(airline,from,to,departure,duration).subscribe(
      () => {
        console.log("posted flight")
      }
    );

    return false;
  }
}
