import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {LocationService} from '../services/location.service';
import supports = CSS.supports;

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {

  @Input() accessRoles: string[];
  @Output() eventEmitter: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(
    public locationService: LocationService
  ) { }

  ngOnInit(): void {
  }

  public submit(locationCode: number, locationName: string,
                locationCountry: string, locationRegion: string): boolean{

    let subscription = this.locationService.addLocation(locationCode,locationName,locationCountry,locationRegion);
    subscription.subscribe(bool =>{
      console.log(bool);
      this.eventEmitter.emit(bool);
    })
    return false;
  }

}
