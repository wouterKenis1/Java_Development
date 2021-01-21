import {Component, Inject, Input, OnInit} from '@angular/core';
import {Flight} from '../models/Flight';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {BookingData} from '../models/BookingData';
import {BookingService} from '../services/booking.service';
import {PayComponent} from '../pay/pay.component';
import {FloatPair} from '../models/FloatPair';
import {Booking} from '../models/Booking';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  //Todo: replace with Booking
  flight: Flight;
  tekstje: string;
  price: number = -1;
  margins: number = 0;
  ticketType: string;
  seats: number;
  paid: boolean;
  payByEndorsement: boolean;
  username: string;


  constructor(
    private bookingService: BookingService,
    public dialogRef: MatDialogRef<BookingComponent>,
    @Inject(MAT_DIALOG_DATA) public data: BookingData,
    public dialog: MatDialog
  )
   { }

  ngOnInit(): void {
    this.flight = this.data.flight;
    this.username = this.data.username;
  }

  tryToBook(ticketType: string, seats:number): boolean{
    //TODO: refactor, clean up this mess
    console.log("trying to book " + seats + " seats in " + ticketType + " class.");
    this.ticketType = ticketType;
    this.seats = seats;
    this.bookingService.getPriceForBooking(this.flight,ticketType,seats)
      .subscribe(numbers => {
        //console.log(numbers);
        numbers.forEach( (float, id) =>{
          if(id === 0){
            this.price = float;
          }
          if(id === 1){
            this.margins = float;
          }
       // console.log(this.price + "|" +  this.margins);
        })

        // open payComponent popup with the given price & flight
        this.openDialog(this.flight,ticketType,seats,this.price,this.margins);
    });
    //console.log(this.price);  // outdated data!
    return false;
  }

  public openDialog(flight: Flight, ticketType: string, seats: number, price: number, margins: number): void {
    const dialogRef = this.dialog.open(PayComponent, {
      // width: '250px',
      data: {flight: flight, ticketType:ticketType, seats: seats, price: price, margins: margins}
    });
    dialogRef.afterClosed().subscribe(result => {
      //console.log(result);
      let temp:boolean[] = (<boolean[]> result);
      //console.log(temp);
      temp.forEach((bool,id) => {
        if(id === 0){this.payByEndorsement = bool;}
        if(id === 1){this.paid = bool;}
      });
      //console.log(this);

      // spring save booking
      // let observable = this.bookingService.createBooking(this.flight.id,this.seats,this.ticketType,this.price,
      //   this.payByEndorsement,this.paid);
      // observable.subscribe(bool =>console.log(bool));

      let booking = new Booking();
      booking.flightID = this.flight.id;
      booking.seatAmount = this.seats;
      booking.seatCategory = this.ticketType;
      booking.bookingPrice = this.price;
      booking.paid = this.paid;
      booking.payByEndorsement = this.payByEndorsement;
      booking.user = this.username;
      this.bookingService.saveBooking(booking).subscribe(result =>{
        //console.log(result);
      })

      // TODO: open dialog informing the user of failed booking
      this.dialogRef.close();
    })
  }
}
