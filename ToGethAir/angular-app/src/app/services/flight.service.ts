import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Flight} from '../models/Flight';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {DatePipe} from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private readonly articlesUrl: string;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };


  constructor(private http: HttpClient) {
    this.articlesUrl = 'http://localhost:8080/flight/';
  }

  public getFlights(): Observable<Flight[]> {
    return this.http.get<Flight[]>(this.articlesUrl + 'getAllFlights');
  }

  public addFlight(airline:string,from:number,to:number,departure:DatePipe,duration:number){
    let params = new HttpParams()
      .set("airline",airline)
      .set("from",String(from))
      .set("to",String(to))
      .set("departure", String(departure))
      .set("duration",String(duration))

    let flight: Flight;
    //console.log(params);
    return this.http.get(this.articlesUrl + 'createFlight',{params: params});

    return this.http.post(this.articlesUrl + 'saveFlight',flight);
  }
}
