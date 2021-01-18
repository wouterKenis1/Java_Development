package com.vdab.models;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PricingInfo {
    int flightID;   // for database purposes
    Map<String, Float> basePrices;  // price per category
//    Map<Integer,Float> promotions;  // seats, discount (in %)
    Vector<Pair<Integer,Float>> promotions;
    public float baseRate = 5.0f;   // default 5% increase from basePrice
    public boolean hasOverride = false;
    public float overrideAmount;

    public Map<String, Float> getBasePrices() {
        return basePrices;
    }

    public void setBasePrices(Map<String, Float> basePrices) {
        this.basePrices = basePrices;
    }

    public Vector<Pair<Integer,Float>> getPromotions() {
        return promotions;
    }

    public Float getBestPromotion(int seatAmount){
        if(hasOverride){
           return 0.0f;
        }
        if(seatAmount == 0 || promotions.size() == 0){
            return 0.0f;
        }
        if(seatAmount < promotions.get(0).getKey()){
            return 0.0f;
        }
        for (int i = 0; i < promotions.size()-1; i++) {
            if(seatAmount < promotions.get(i).getKey()){
                return promotions.get(i-1).getValue();
            }
        }
        return promotions.lastElement().getValue();
    }

    public Float getMargins(float basePrice){
        if(hasOverride){
            return overrideAmount;
        }
        return baseRate/100 * basePrice;
    }

    public void addPromotion(Pair<Integer,Float> promotion){
        this.promotions.add(promotion);
    }

    public void setPromotions(Vector<Pair<Integer,Float>> promotions) {
        this.promotions = promotions;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }
}
