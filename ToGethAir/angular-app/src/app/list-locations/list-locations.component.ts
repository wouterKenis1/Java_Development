import {Component, Input, OnInit} from '@angular/core';
import {Location} from '../models/Location';
import {LocationService} from '../services/location.service';

@Component({
  selector: 'app-list-locations',
  templateUrl: './list-locations.component.html',
  styleUrls: ['./list-locations.component.css']
})
export class ListLocationsComponent implements OnInit {

  locations: Location[] = [];
  @Input() accessRoles: string[];

  constructor(
    private locationService: LocationService
  ) { }

  ngOnInit(): void {
    this.refreshList();
  }

  refreshList(): void{
    this.locationService.getLocations().subscribe(articles => {this.locations = articles; });
  }

  deleteLocation(location: Location): boolean{
    var x =  this.locationService.deleteLocation(location.code).subscribe(
      () => {
        this.refreshList();
      }
    );
    return false;
  }


}
