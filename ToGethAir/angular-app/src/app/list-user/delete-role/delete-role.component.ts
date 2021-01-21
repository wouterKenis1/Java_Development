import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete-role',
  templateUrl: './delete-role.component.html',
  styleUrls: ['./delete-role.component.css']
})
export class DeleteRoleComponent implements OnInit {

  role:string = "";

  constructor(
    public dialogRef: MatDialogRef<DeleteRoleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  submit(): boolean{
    this.dialogRef.close(this.role)
    return false;
  }

}
