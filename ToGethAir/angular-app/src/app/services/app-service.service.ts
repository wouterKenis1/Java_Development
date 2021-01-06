import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from '../models/Location';

@Injectable({providedIn: 'root'})
export class AppService {
  private readonly articlesUrl: string;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };


  constructor(private http: HttpClient) {
    this.articlesUrl = 'http://localhost:8080/';
  }

  public getLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(this.articlesUrl + 'getAllLocations');
  }


}
