import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticatorService {

  private readonly articlesUrl: string;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };

  roles:string[] = [];


  constructor(private http: HttpClient) {
    this.articlesUrl = 'http://localhost:8080/user/';
  }

  public getAuthentication(username:string, pass:string): Observable<boolean>{
    let params = new HttpParams()
      .set("username",username)
      .set("password",pass);
    return this.http.get<boolean>(this.articlesUrl + 'validateUser', {params:params});
  }

  public saveUser(username: string, password: string): Observable<boolean>{

    return this.http.post<boolean>(this.articlesUrl + 'saveUser', {username,password});
  }

  public giveUserRole(username: string, accessRole: string): Observable<boolean>{
    return this.http.post<boolean>(this.articlesUrl + 'giveUserRole', {username,accessRole});
  }

  public getAllUserStrings():Observable<string[]>{
    return this.http.get<string[]>(this.articlesUrl + 'getAllUserStrings');
  }

  public getRolesForUser(username: string): Observable<string[]>{
    let params = new HttpParams()
      .set("username",username)
    return this.http.get<string[]>(this.articlesUrl + 'getRolesForUser', {params:params});
  }

  public removeUserRole(username: string, accessRole: string): Observable<boolean>{
    return this.http.post<boolean>(this.articlesUrl + 'removeUserRole', {username,accessRole});
  }
}
