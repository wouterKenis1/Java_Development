package com.vdab.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import javafx.util.Pair;

public class Flight {

    int id;
    Timestamp departureTime;
    float duration;
    PricingInfo pricingInfo;
    Map<String,Integer> seatingInfo; // amount of available seats by category
    String airline;
    int departureLocationCode;
    int arrivalLocationCode;


    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public PricingInfo getPricingInfo() {
        return pricingInfo;
    }

    public void setPricingInfo(PricingInfo pricingInfo) {
        this.pricingInfo = pricingInfo;
    }

    public Map<String, Integer> getSeatingInfo() {
        return seatingInfo;
    }

    public void setSeatingInfo(Map<String, Integer> seatingInfo) {
        this.seatingInfo = seatingInfo;
    }


    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartureLocationCode() {
        return departureLocationCode;
    }

    public void setDepartureLocationCode(int departureLocationCode) {
        this.departureLocationCode = departureLocationCode;
    }

    public int getArrivalLocationCode() {
        return arrivalLocationCode;
    }

    public void setArrivalLocationCode(int arrivalLocationCode) {
        this.arrivalLocationCode = arrivalLocationCode;
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
}
