import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticatorService {

  constructor() { }

  public getAuthentication(username:string, pass:string){
    let x: string[] = [];
    switch(username){
      case "Bert":
        if(pass === "pass"){
        x.push("customer");
        }
        break;
      case "Wouter":
        if(pass === "lol") {
          x.push("admin", "customer", "employee", "airline","bookingEnabled",
            "canAddLocation","canDeleteLocation","canAddFlight");
        }
        break;
      case "Timothy":
        if(pass === "secret") {
          x.push("employee");
        }
        break;
      default:
        console.log("Authentication failed!");
    }
    return x;
  }
}
