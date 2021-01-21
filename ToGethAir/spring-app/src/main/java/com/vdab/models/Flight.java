package com.vdab.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import javafx.util.Pair;

public class Flight {

    int id;
    LocalDateTime departureTime;
    float duration;
    PricingInfo pricingInfo;
    Map<String,Integer> seatingInfo; // amount of available seats by category
    String airline;
    int departureLocationCode;
    int arrivalLocationCode;

    public int getId() {
        return id;
    }

    public Flight setId(int id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Flight setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public float getDuration() {
        return duration;
    }

    public Flight setDuration(float duration) {
        this.duration = duration;
        return this;
    }

    public PricingInfo getPricingInfo() {
        return pricingInfo;
    }

    public Flight setPricingInfo(PricingInfo pricingInfo) {
        this.pricingInfo = pricingInfo;
        return this;
    }

    public Map<String, Integer> getSeatingInfo() {
        return seatingInfo;
    }

    public Flight setSeatingInfo(Map<String, Integer> seatingInfo) {
        this.seatingInfo = seatingInfo;
        return this;
    }

    public String getAirline() {
        return airline;
    }

    public Flight setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public int getDepartureLocationCode() {
        return departureLocationCode;
    }

    public Flight setDepartureLocationCode(int departureLocationCode) {
        this.departureLocationCode = departureLocationCode;
        return this;
    }

    public int getArrivalLocationCode() {
        return arrivalLocationCode;
    }

    public Flight setArrivalLocationCode(int arrivalLocationCode) {
        this.arrivalLocationCode = arrivalLocationCode;
        return this;
    }

    // TODO: move this function to somewhere else
    public float calculateCosts(Map<String,Integer> seatsPerClass){
        // calculate the costs of booking seats for this flight

        float costs = 0.0f;
        int totalSeatAmount = 0;
        for(Map.Entry<String,Integer> seats : seatsPerClass.entrySet()){
            costs = pricingInfo.getBasePrices().get(seats.getKey()) * seats.getValue();
            totalSeatAmount += seats.getValue();
        }

        int promotionSelector = 0;
        while(promotionSelector < pricingInfo.promotions.size()){
            if(totalSeatAmount < pricingInfo.promotions.elementAt(promotionSelector).getKey()){
                break;
            }
            promotionSelector++;
        }
        if(promotionSelector == 0 && totalSeatAmount < pricingInfo.promotions.elementAt(0).getKey()){
            return costs * pricingInfo.baseRate;
        }
        if(promotionSelector >= pricingInfo.promotions.size()){
            promotionSelector = pricingInfo.promotions.size() - 1;
        }

        costs *= 1 - (pricingInfo.promotions.get(promotionSelector).getValue()) / 100;

        return costs;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureTime=" + departureTime +
                ", duration=" + duration +
                ", pricingInfo=" + pricingInfo +
                ", seatingInfo=" + seatingInfo +
                ", airline='" + airline + '\'' +
                ", departureLocationCode=" + departureLocationCode +
                ", arrivalLocationCode=" + arrivalLocationCode +
                '}';
    }
}
