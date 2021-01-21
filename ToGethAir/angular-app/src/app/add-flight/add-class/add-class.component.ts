import {Component, Inject, Input, OnInit} from '@angular/core';
import {Flight} from '../../models/Flight';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {BookingData} from '../../models/BookingData';

@Component({
  selector: 'app-add-class',
  templateUrl: './add-class.component.html',
  styleUrls: ['./add-class.component.css']
})
export class AddClassComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<AddClassComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Flight,
    public dialog: MatDialog
  ){

  }


  ngOnInit(): void {
  }

  public submit(className: string, availableSeats: number, basePrice: number){

    // this.data.seatingInfo.set(className,availableSeats);
    this.data.seatingInfo[className] = availableSeats;
    // this.data.pricingInfo.basePrises.set(className,basePrice);
    this.data.pricingInfo.basePrices[className] = basePrice;

    this.dialogRef.close(this.data);
    return false;
  }

}
