import { Component, OnInit } from '@angular/core';
import {AppService} from '../services/app-service.service';
import {Location} from '../models/Location';

@Component({
  selector: 'app-list-locations',
  templateUrl: './list-locations.component.html',
  styleUrls: ['./list-locations.component.css']
})
export class ListLocationsComponent implements OnInit {

  locations: Location[] = [];

  constructor(
    private appService: AppService
  ) { }

  ngOnInit(): void {
    this.appService.getLocations().subscribe(articles => {this.locations = articles; });
  }

}
