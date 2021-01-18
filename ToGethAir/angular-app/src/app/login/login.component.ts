import { Component, OnInit } from '@angular/core';
import {AuthenticatorService} from '../services/authenticator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  roles:string[]=[];

  constructor(
    private authenticatorService: AuthenticatorService
  ) { }

  ngOnInit(): void {
  }

  public getRoles(user:string,pass:string):boolean{
    this.roles = this.authenticatorService.getAuthentication(user,pass);
    console.log(this.roles);
    return false;
  }

}
