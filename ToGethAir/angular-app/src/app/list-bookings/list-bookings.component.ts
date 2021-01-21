import {Component, Input, OnInit} from '@angular/core';
import {Booking} from '../models/Booking';
import {BookingService} from '../services/booking.service';

@Component({
  selector: 'app-list-bookings',
  templateUrl: './list-bookings.component.html',
  styleUrls: ['./list-bookings.component.css']
})
export class ListBookingsComponent implements OnInit {

  @Input() accessRoles: string[];
  @Input() username: string;
  bookings: Booking[];
  searchName: string = "";

  constructor(
    public bookingService: BookingService
  ) { }

  ngOnInit(): void {
    this.updateBookings();
  }

  public updateBookings(){
    if(this.accessRoles.includes('admin')){
      if(this.searchName == ""){
        return this.bookingService.getAllBookings().subscribe(bookings =>{
          this.bookings = bookings;
        })
      }else{
        this.bookingService.findBookingsForUser(this.searchName).subscribe(bookings =>{
          this.bookings = bookings;
        })
      }
    }else{
      this.bookingService.findBookingsForUser(this.username).subscribe(bookings =>{
        this.bookings = bookings;
      })
    }
    console.log(this.bookings);
  }

}
