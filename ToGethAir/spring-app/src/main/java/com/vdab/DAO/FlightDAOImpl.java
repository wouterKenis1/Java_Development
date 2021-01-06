package com.vdab.DAO;

import com.vdab.App.User;
import com.vdab.models.Flight;
import com.vdab.models.Location;
import com.vdab.models.PricingInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightDAOImpl implements FlightDAO {

    final private String url = User.getUrl();
    final private String pass = User.getPass();
    final private String user = User.getUser();

    @Autowired
    PricingInfoDAO pricingInfoDAO;

    // region seatingDAO
    private Map<String,Integer> getSeatingInfo(int flightID){
        Map<String, Integer> seatingInfo = new HashMap<>();
        String sql = "SELECT * FROM seatinginfos WHERE flightid = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,flightID);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String flightClass = rs.getString("flightclass");
                Integer availableSeats = rs.getInt("availableseats");

                seatingInfo.put(flightClass,availableSeats);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seatingInfo;
    }

    public void saveSeatingInfo(Flight flight) {
        String sql = "INSERT INTO seatinginfos (flightid,flightclass,availableseats) VALUES (?,?,?)";

        Map<String, Integer> seatingInfo = flight.getSeatingInfo();

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,flight.getId());
                for (var x : seatingInfo.entrySet()){
                    pstmt.setString(2,x.getKey());
                    pstmt.setInt(3,x.getValue());
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSeatingInfo(Flight flight) {
        String sql = "UPDATE seatinginfos SET " +
                "flightclass = ?," +
                "availableseats= ?" +
                " WHERE flightid = ?";
        Map<String, Integer> seatingInfo = flight.getSeatingInfo();

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                for (var x : seatingInfo.entrySet()){
                    pstmt.setString(1,x.getKey());
                    pstmt.setInt(2,x.getValue());
                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //endregion

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Flight flight = new Flight();

                flight.setId(rs.getInt("id"));
                flight.setAirline(rs.getString("airline"));
                flight.setDuration(rs.getFloat("duration"));
                flight.setDepartureTime(rs.getTimestamp("departuretime"));
                flight.setDepartureLocationCode(rs.getInt("departurelocationcode"));
                flight.setArrivalLocationCode(rs.getInt("arrivallocationcode"));


                PricingInfo pricingInfo = pricingInfoDAO.getPricingInfo(flight.getId());
                flight.setPricingInfo(pricingInfo);

                Map<String,Integer> seatingInfo = getSeatingInfo(flight.getId());
                flight.setSeatingInfo(seatingInfo);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    @Override
    public List<Flight> findFlightsByLocation(int locationCode) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT flight FROM flights WHERE flight.departurelocationcode = ? OR flight.arrivallocationcode = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,locationCode);
            st.setInt(2,locationCode);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Flight flight = new Flight();

                flight.setId(rs.getInt("id"));
                flight.setAirline(rs.getString("airline"));
                flight.setDuration(rs.getFloat("duration"));
                flight.setDepartureTime(rs.getTimestamp("departuretime"));
                flight.setDepartureLocationCode(rs.getInt("departurelocationcode"));
                flight.setArrivalLocationCode(rs.getInt("arrivallocationcode"));
                PricingInfo pricingInfo = pricingInfoDAO.getPricingInfo(flight.getId());
                flight.setPricingInfo(pricingInfo);

                Map<String,Integer> seatingInfo = getSeatingInfo(flight.getId());
                flight.setSeatingInfo(seatingInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    @Override
    public List<Flight> findFlightsByDate(Timestamp departureDate) {
        return null;
    }

    @Override
    public List<Flight> findFlightsByAirline(String airline) {
        return null;
    }

    @Override
    public void saveFlight(Flight flight) {
        String sql = "INSERT INTO flights (name, country, region, code) VALUES (?,?,?,?)";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
