import {Component, Input, OnInit} from '@angular/core';
import {Location} from '../models/Location';
import {LocationService} from '../services/location.service';
import {AuthenticatorService} from '../services/authenticator.service';
import {Flight} from '../models/Flight';
import {BookingComponent} from '../booking/booking.component';
import {MatDialog} from '@angular/material/dialog';
import {AddRoleComponent} from './add-role/add-role.component';
import {DeleteRoleComponent} from './delete-role/delete-role.component';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  usernames: string[] = [];
  @Input() accessRoles: string[];

  users:Map<string,string[]> = new Map<string,string[]>();

  constructor(
    private authenticatorService: AuthenticatorService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.updateUsers()
  }

  public updateUsers(){
    this.authenticatorService.getAllUserStrings().subscribe(users =>{
      this.usernames = users;
    });
    this.usernames.forEach(username =>{
      this.authenticatorService.getRolesForUser(username).subscribe(roles =>{
        this.users.set(username,roles);
      })
    })
  }

  public openDialogAddRole(username:string): boolean {

    const dialogRef = this.dialog.open(AddRoleComponent,{
      // width: '250px',
      data:username
    });

    dialogRef.afterClosed().subscribe(result =>{
      this.authenticatorService.giveUserRole(username,result).subscribe(isRoleAdded =>{
        //console.log(isRoleAdded);
        this.updateUsers();
      });
    });
    return false;
  }

  public openDialogDeleteRole(username:string): boolean {

    const dialogRef = this.dialog.open(DeleteRoleComponent,{
      // width: '250px',
      data:username
    });

    dialogRef.afterClosed().subscribe(result =>{
      this.authenticatorService.removeUserRole(username,result).subscribe(isRoleDeleted =>{
        //console.log(isRoleDeleted);
        this.updateUsers();
      });
    });
    return false;
  }

}
