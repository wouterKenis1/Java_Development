import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Location} from '../models/Location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

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
    this.articlesUrl = 'http://localhost:8080/location/';
  }

  public getLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(this.articlesUrl + 'getAllLocations');
  }

  public addLocation(locationCode: number, locationName: string,
                     locationCountry: string, locationRegion: string): Observable<boolean>{
    let params = new HttpParams()
      .set("locationCode", String(locationCode))
      .set("locationName", locationName)
      .set("locationCountry", locationCountry)
      .set("locationRegion", locationRegion)
    return this.http.get<boolean>(this.articlesUrl + 'addLocation',{params: params});
  }

  public deleteLocation(locationCode: number): Observable<any>{
    let params = new HttpParams()
      .set("locationCode",locationCode.toString())
    //this.http.get(this.articlesUrl + 'deleteLocation',{params: params});
    return this.http.delete(this.articlesUrl + 'deleteLocation',{params: params})
  }

}
