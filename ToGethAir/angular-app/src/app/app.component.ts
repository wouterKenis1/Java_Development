import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';

  access: string[] = [];

  public getRolesFromLoginComponent(roles:string[]){
    this.access = roles;
    console.log(this.access);
  }
}
