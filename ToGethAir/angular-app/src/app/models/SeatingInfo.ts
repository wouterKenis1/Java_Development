export class SeatingInfo{
  ticketTypes: string[] = [];
  availableSeats: number[] = [];

  getTotalSeats(){
    let total = 0;
    this.availableSeats.forEach(num => {total += num;});

    return total;
  }



}
