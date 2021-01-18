package com.vdab.DAO;

import com.vdab.App.DataBaseAccess;
import com.vdab.models.PricingInfo;
import javafx.util.Pair;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class PricingInfoDAOImpl implements PricingInfoDAO {

    final private String url = DataBaseAccess.getUrl();
    final private String pass = DataBaseAccess.getPass();
    final private String user = DataBaseAccess.getUser();

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

    @Override
    public void savePricingInfo(PricingInfo pricingInfo) {
        saveBasePrices(pricingInfo.getBasePrices(), pricingInfo.getFlightID());
        savePromotions(pricingInfo.getPromotions(), pricingInfo.getFlightID());
    }

    @Override
    public void saveBasePrices(Map<String, Float> basePrices, int flightID) {
        String sql = "INSERT INTO baseprices" +
                " (flightclass, baseprice, flightid)" +
                " VALUES" +
                " (?,?,?)";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3,flightID);

            for(var x : basePrices.entrySet()) {
                pstmt.setString(1, x.getKey());
                pstmt.setFloat(2,x.getValue());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePromotions(Vector<Pair<Integer, Float>> promotions, int flightID) {
        String sql = "INSERT INTO promotions" +
                " (discountpercent, seatamount, flightid)" +
                " VALUES" +
                " (?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3, flightID);

            for (Pair<Integer, Float> promotion : promotions) {
                pstmt.setFloat(1, promotion.getValue());
                pstmt.setInt(2, promotion.getKey());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePricingInfo(PricingInfo pricingInfo) {
        updateBasePrices(pricingInfo.getBasePrices(), pricingInfo.getFlightID());
        updatePromotions(pricingInfo.getPromotions(), pricingInfo.getFlightID());
    }

    @Override
    public void updateBasePrices(Map<String, Float> basePrices, int flightID) {
        String sql = "UPDATE baseprices " +
                "SET baseprice = ? " +
                "WHERE flightid = ? AND flightclass = ?";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2,flightID);

            for(var x : basePrices.entrySet()) {
                pstmt.setFloat(1,x.getValue());
                pstmt.setString(3, x.getKey());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePromotions(Vector<Pair<Integer, Float>> promotions, int flightID) {
        String sql = "UPDATE promotions" +
                " SET discountpercent = ?, seatamount = ? " +
                "WHERE flightid = ?";
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3, flightID);

            for (Pair<Integer, Float> promotion : promotions) {
                pstmt.setFloat(1, promotion.getValue());
                pstmt.setInt(2, promotion.getKey());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
