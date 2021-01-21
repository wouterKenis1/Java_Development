import { Injectable } from '@angular/core';
import {Flight} from '../models/Flight';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Booking} from '../models/Booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private readonly articlesUrl: string;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };

  constructor(
    private http: HttpClient
  ) {
    this.articlesUrl = 'http://localhost:8080/booking/';
  }

  public getAllBookings(): Observable<Booking[]>{
    return this.http.get<Booking[]>(this.articlesUrl + 'getAllBookings');
  }

  public findBookingsForUser(username: string): Observable<Booking[]>{
    let params = new HttpParams()
      .set("username",username)
    return this.http.get<Booking[]>(this.articlesUrl + 'findBookingsForUser', {params: params});
  }

  public getPriceForBooking(flight: Flight, type: string, amount: number): Observable<number[]> {
    let params = new HttpParams()
      .set("flightID",String(flight.id))
      .set("type", type)
      .set("amount", String(amount)); //Create new HttpParams
    return this.http.get<number[]>(this.articlesUrl + 'getPriceForBooking',{params: params});
  }


  public saveBooking(booking: Booking): Observable<boolean>{
    return this.http.post<boolean>(this.articlesUrl + 'saveBooking', booking);
  }

  public getBookingsAmount(): Observable<number>{
    return this.http.get<number>(this.articlesUrl + 'getBookingsAmount');
  }

  public getAverageBookingPrice(): Observable<number>{
    return this.http.get<number>(this.articlesUrl + 'getAverageBookingPrice');
  }

  public getMinBookingPrice(): Observable<number>{
    return this.http.get<number>(this.articlesUrl + 'getMinBookingPrice');
  }

  public getMaxBookingPrice(): Observable<number>{
    return this.http.get<number>(this.articlesUrl + 'getMaxBookingPrice');
  }



}
