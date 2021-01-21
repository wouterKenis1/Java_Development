package com.vdab.controllers;

import com.vdab.models.Booking;
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
    @RequestMapping(value="/getAllBookings",method = RequestMethod.GET)
    public Iterable<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @RequestMapping(value="/findBookingsForUser",method = RequestMethod.GET)
    public Iterable<Booking> findBookingsForUser(@RequestParam String username){
        System.out.println("find bookings for: " + username);
        Iterable<Booking> bookings = bookingService.findBookingsByUsername(username);
        bookings.forEach(booking -> {
            System.out.println(booking.getBookingID() + ": " + booking.isPaid() + " "+ booking.isPayByEndorsement());
        });
        return bookings;
    }


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

    @RequestMapping(value="/getBookingsAmount",method = RequestMethod.GET)
    public int getBookingsAmount(){
        return bookingService.getBookingsAmount();
    }
    @RequestMapping(value="/getAverageBookingPrice",method = RequestMethod.GET)
    public int getAverageBookingPrice(){
        return bookingService.getAverageBookingPrice();
    }
    @RequestMapping(value="/getMinBookingPrice",method = RequestMethod.GET)
    public int getMinBookingPrice(){
        return bookingService.getMinBookingPrice();
    }
    @RequestMapping(value="/getMaxBookingPrice",method = RequestMethod.GET)
    public int getMaxBookingPrice(){
        return bookingService.getMaxBookingPrice();
    }

    // endregion


    // region setters
    @RequestMapping(value = "/createBooking",method = RequestMethod.GET)
    public boolean saveBooking(@RequestParam int flightID,@RequestParam int seatAmount,
                               @RequestParam String seatCategory,@RequestParam float bookingPrice,
                               @RequestParam boolean payByEndorsement,@RequestParam boolean isPaid){

        System.out.println("saveBooking request made");
        return bookingService.createBooking(flightID,seatAmount,seatCategory,bookingPrice,
                payByEndorsement,isPaid,"");
    }

    @RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
    public boolean saveBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }
    // endregion

}
