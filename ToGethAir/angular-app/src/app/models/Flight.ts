import {PricingInfo} from './PricingInfo';
import {Location} from './Location';
import {SeatingInfo} from './SeatingInfo';

export class Flight{
  id: number;
  departureTime: string;        // Timestamp
  duration: number;
  pricingInfo: PricingInfo = new PricingInfo();
  airline: string;
  departureLocationCode: number;  // Location
  arrivalLocationCode: number;    // Location
  // seatingInfo not done here due to Map<String,Integer>
  //  seatingInfo: SeatingInfo;
  // seatingInfo: Map<string,number> = new Map<string, number>();
  seatingInfo: {} = {};
}
