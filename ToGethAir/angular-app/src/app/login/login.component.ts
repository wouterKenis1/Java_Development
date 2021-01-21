import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthenticatorService} from '../services/authenticator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  roles:string[]=[];
  username: string = "";
  @Output() loginEventEmitter: EventEmitter<any> = new EventEmitter()
  constructor(
    private authenticatorService: AuthenticatorService
  ) { }

  ngOnInit(): void {
  }

  public getRoles(user:string,pass:string):boolean{
    // this.authenticatorService.getAuthentication(user,pass).subscribe(accessGranted =>{
    //   if(accessGranted){
    //       console.log("Access granted")
    //     this.authenticatorService.getRolesForUser(user).subscribe(roles =>{
    //       this.roles = roles;
    //       this.username = user;
    //       console.log(this.username);
    //       console.log(this.roles)
    //     })
    //   }else{
    //     console.log("Access denied")
    //     this.roles = [];
    //     this.username = user;
    //     console.log(this.username);
    //     console.log(this.roles)
    //   }
    // })
    // return false;
  this.authenticatorService.getAuthentication(user,pass).toPromise().then(accessGranted =>{
    if(accessGranted){
      console.log("Access granted")
      this.authenticatorService.getRolesForUser(user).toPromise().then(roles =>{
          this.roles = roles;
          this.username = user;
          console.log(this.username);
          console.log(this.roles)
          this.loginEventEmitter.emit();
        })
      }else{
        console.log("Access denied")
        this.roles = [];
        this.username = user;
        console.log(this.username);
        console.log(this.roles)
        this.loginEventEmitter.emit();
      }
    })
  return false;
  }


}
