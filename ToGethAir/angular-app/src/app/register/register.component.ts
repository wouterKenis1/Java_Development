import { Component, OnInit } from '@angular/core';
import {AuthenticatorService} from '../services/authenticator.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(
    public authenticatorService: AuthenticatorService
  ) { }

  ngOnInit(): void {
  }

  public saveUser(username: string, password: string){
    if(username != ""){
      this.authenticatorService.saveUser(username,password).toPromise().then(result =>{
        console.log(result);
      })
      this.authenticatorService.giveUserRole(username,"user").toPromise().then(result =>{
        console.log(result);
      })
      this.authenticatorService.giveUserRole(username,"bookingEnabled").toPromise().then(result =>{
        console.log(result);
      })
    }
    return true;
  }

}
