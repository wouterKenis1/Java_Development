package com.vdab.DAO;

import com.vdab.App.User;
import com.vdab.models.Flight;
import com.vdab.models.PricingInfo;
import javafx.util.Pair;

import java.sql.*;
import java.util.*;

public class PricingInfoDAOImpl implements PricingInfoDAO {

    final private String url = User.getUrl();
    final private String pass = User.getPass();
    final private String user = User.getUser();

    @Override
    public PricingInfo getPricingInfo(int flightID) {
        PricingInfo pricingInfo = new PricingInfo();

        pricingInfo.setFlightID(flightID);
        pricingInfo.setBasePrices(getBasePrices(flightID));
        pricingInfo.setPromotions(getPromotions(flightID));

        return pricingInfo;
    }

    @Override
    public Map<String, Float> getBasePrices(int flightID) {
        Map<String, Float> basePrices = new HashMap<>();
        String sql = "SELECT * FROM baseprices WHERE flightid = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,flightID);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String flightClass = rs.getString("flightclass");
                Float price = rs.getFloat("baseprice");

                basePrices.put(flightClass,price);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return basePrices;
    }

    @Override
    public Vector<Pair<Integer, Float>> getPromotions(int flightID) {
        Vector<Pair<Integer, Float>> promotions = new Vector<>() {};
        String sql = "SELECT * FROM promotions WHERE flightid = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,flightID);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Integer seats = rs.getInt("seatamount");
                Float percent = rs.getFloat("discountpercent");
                promotions.add(new Pair<>(seats,percent));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotions;
    }
}
