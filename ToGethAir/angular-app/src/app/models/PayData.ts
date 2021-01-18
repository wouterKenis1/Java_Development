import {Flight} from './Flight';

export interface PayData{
  flight: Flight;
  ticketType: string;
  seats: number;
  price: number;
  margins: number;

}
