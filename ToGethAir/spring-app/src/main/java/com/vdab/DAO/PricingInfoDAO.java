package com.vdab.DAO;

import com.vdab.models.PricingInfo;
import javafx.util.Pair;

import java.util.Map;
import java.util.Vector;

public interface PricingInfoDAO {

    PricingInfo getPricingInfo(int FlightId);
    Map<String,Float> getBasePrices(int FlightId);
    Vector<Pair<Integer,Float>> getPromotions(int FlightId);

    void savePricingInfo(PricingInfo pricingInfo);
    void saveBasePrices(Map<String,Float> basePrices, int flightID);
    void savePromotions(Vector<Pair<Integer,Float>> promotions, int flightID);

    void updatePricingInfo(PricingInfo pricingInfo);
    void updateBasePrices(Map<String, Float> basePrices, int flightID);
    void updatePromotions(Vector<Pair<Integer, Float>> promotions, int flightID);

}
