import {Component, Input, OnInit} from '@angular/core';
import {Booking} from '../models/Booking';
import {BookingService} from '../services/booking.service';
import {BigInteger} from '@angular/compiler/src/i18n/big_integer';

@Component({
  selector: 'app-reporting',
  templateUrl: './reporting.component.html',
  styleUrls: ['./reporting.component.css']
})
export class ReportingComponent implements OnInit {

  @Input() accessRoles: string[] = [];


  bookings: Booking[];
  bookingAmount: number;
  paidBookings: Booking[];
  notPaidBookings: Booking[];

  priceAverage: number;
  priceMin: number;
  priceMax: number;

  constructor(
    public bookingService: BookingService
  ) { }

  ngOnInit(): void {
    this.updateBookings();
  }

  updateBookings(){
    this.paidBookings = [];
    this.notPaidBookings = [];
    this.bookingService.getAllBookings().subscribe((bookings)=>{
      this.bookings = bookings;
      bookings.forEach(booking =>{
        if(booking.paid){
          this.paidBookings.push(booking);
        }else{
          this.notPaidBookings.push(booking);
        }
      })

      //console.log(bookings);
     // console.log(this.bookings);
      //console.log(this.paidBookings);
      //console.log(this.notPaidBookings);

    })
  }

  public updateValues(){
     this.getBookingsLength();
     this.getAveragePrice();
     this.getMinPrice();
     this.getMaxPrice();
  }

  public getBookingsLength(){
    this.bookingService.getBookingsAmount().subscribe(num =>{
      //console.log(num);
      this.bookingAmount = num;
    })
  }

  public getAveragePrice(){
    this.bookingService.getAverageBookingPrice().subscribe(num =>{
      //console.log(num);
      this.priceAverage = num;
    })
  }

  public getMinPrice(){
    this.bookingService.getMinBookingPrice().subscribe(num =>{
     // console.log(num);
      this.priceMin = num;
    })
  }

  public getMaxPrice(){
    this.bookingService.getMaxBookingPrice().subscribe(num =>{
     // console.log(num);
      this.priceMax = num;
    })
  }

}
