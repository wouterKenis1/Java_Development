import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {Flight} from '../../models/Flight';

@Component({
  selector: 'app-add-role',
  templateUrl: './add-role.component.html',
  styleUrls: ['./add-role.component.css']
})
export class AddRoleComponent implements OnInit {

  newRole:string = "";

  constructor(
    public dialogRef: MatDialogRef<AddRoleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  submit(): boolean{
    this.dialogRef.close(this.newRole)
    return false;
  }

}
