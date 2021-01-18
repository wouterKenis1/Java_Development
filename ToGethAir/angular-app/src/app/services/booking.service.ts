import { Injectable } from '@angular/core';
import {Flight} from '../models/Flight';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

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

  public getPriceForBooking(flight: Flight, type: string, amount: number): Observable<number[]> {
    let params = new HttpParams()
      .set("flightID",String(flight.id))
      .set("type", type)
      .set("amount", String(amount)); //Create new HttpParams
    return this.http.get<number[]>(this.articlesUrl + 'getPriceForBooking',{params: params});
  }

  public saveBooking(flightID:number, seatAmount:number, seatCategory:string, bookingPrice:number,
                     payByEndorsement:boolean, isPaid:boolean ): Observable<boolean>{

    let params = new HttpParams()
      .set("flightID", String(flightID))
      .set("seatAmount", String(seatAmount))
      .set("seatCategory", seatCategory)
      .set("bookingPrice", String(bookingPrice))
      .set("payByEndorsement",String(payByEndorsement))
      .set("isPaid",String(isPaid));

    return this.http.get<boolean>(this.articlesUrl + 'createBooking',{params: params});
  }



}
