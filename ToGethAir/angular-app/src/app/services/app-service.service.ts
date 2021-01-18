import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from '../models/Location';
import {Flight} from '../models/Flight';

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
  }


//   public intercept(string url){
//     // add auth token
//     // return this.http.get<Flight[]>(url);
// }

}
