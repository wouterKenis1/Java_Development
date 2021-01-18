package com.vdab.controllers;

import com.vdab.services.BookingService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // region getters
    @RequestMapping(value="/getPriceForBooking",method = RequestMethod.GET)
    public Iterable<Float> getPriceForBooking(@RequestParam int amount, @RequestParam int flightID,
                                              @RequestParam String type){
        //TODO: implement a proper getPriceForBooking method
        Pair<Float,Float> returnValue = bookingService.calculatePrice(flightID, type, amount);
        List<Float> list = new ArrayList<Float>();
        list.add(returnValue.getKey());
        list.add(returnValue.getValue());
        Iterable<Float> returnIterable = list;
        return returnIterable;
    }
    // endregion


    // region setters
    @RequestMapping(value = "/createBooking",method = RequestMethod.GET)
    public boolean saveBooking(@RequestParam int flightID,@RequestParam int seatAmount,
                               @RequestParam String seatCategory,@RequestParam float bookingPrice,
                               @RequestParam boolean payByEndorsement,@RequestParam boolean isPaid){

        System.out.println("saveBooking request made");
        return bookingService.createBooking(flightID,seatAmount,seatCategory,bookingPrice,
                payByEndorsement,isPaid);
    }
    // endregion

}
