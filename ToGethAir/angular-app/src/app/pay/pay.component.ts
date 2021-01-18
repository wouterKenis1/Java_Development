import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {BookingData} from '../models/BookingData';
import {PayData} from '../models/PayData';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {

  payByEndorsement: boolean = true;
  paid: boolean = false;

  constructor(
    public dialogRef: MatDialogRef<PayComponent>,
    @Inject(MAT_DIALOG_DATA) public data: PayData,
  ) { }

  ngOnInit(): void {
  }

  public changePayMethod(): void{
    this.payByEndorsement = !this.payByEndorsement;
  }

  public doPayment(): boolean{
    if(!this.payByEndorsement) {
      this.paid = true; // use payment api instead
    }
    else{
      this.paid = false;
    }
    this.closeDialog();
    return false;
  }

  public closeDialog(): void{
    let result: boolean[] = [];
    result.push(this.payByEndorsement);
    result.push(this.paid);
    this.dialogRef.close(result);
  }
}
