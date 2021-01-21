package com.vdab.models;

public class Booking {
    int bookingID;
    int flightID;
    int seatAmount = 0;
    String seatCategory = "";
    float bookingPrice = 0.0f;
    boolean isPaid = false;
    boolean isPayByEndorsement = false;
    String user = "";

    public boolean isPayByEndorsement() {
        return isPayByEndorsement;
    }

    public Booking setPayByEndorsement(boolean payByEndorsement) {
        this.isPayByEndorsement = payByEndorsement;
        return this;
    }

    public int getBookingID() {
        return bookingID;
    }

    public Booking setBookingID(int bookingID) {
        this.bookingID = bookingID;
        return this;
    }

    public int getFlightID() {
        return flightID;
    }

    public Booking setFlightID(int flightID) {
        this.flightID = flightID;
        return this;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public Booking setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
        return this;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public Booking setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
        return this;
    }

    public float getBookingPrice() {
        return bookingPrice;
    }

    public Booking setBookingPrice(float bookingPrice) {
        this.bookingPrice = bookingPrice;
        return this;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Booking setPaid(boolean paid) {
        isPaid = paid;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Booking setUser(String user) {
        this.user = user;
        return this;
    }
}
