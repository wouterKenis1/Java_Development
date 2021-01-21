import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';
  username: string = "";
  access: string[] = [];

  public getFromLoginComponent(name:string, roles:string[]){
    this.getNameFromLoginComponent(name);
    this.getRolesFromLoginComponent(roles)

  }

  public getNameFromLoginComponent(name: string){
    this.username = name;
  }

  public getRolesFromLoginComponent(roles:string[]){
    this.access = roles;
  }



}
