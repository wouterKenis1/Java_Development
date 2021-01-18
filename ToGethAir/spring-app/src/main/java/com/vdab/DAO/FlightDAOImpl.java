package com.vdab.DAO;

import com.vdab.App.DataBaseAccess;
import com.vdab.models.Flight;
import com.vdab.models.PricingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightDAOImpl implements FlightDAO {

    final private String url = DataBaseAccess.getUrl();
    final private String pass = DataBaseAccess.getPass();
    final private String user = DataBaseAccess.getUser();

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

    public void updateSeatingInfo(Flight flight){
        String sql = "UPDATE seatinginfos " +
                "SET flightclass = ?, availableseats = ? " +
                "WHERE flightid = ?";

        Map<String, Integer> seatingInfo = flight.getSeatingInfo();
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(3,flight.getId());
                for (var x : seatingInfo.entrySet()){
                    pstmt.setString(1,x.getKey());
                    pstmt.setInt(2,x.getValue());
                    pstmt.executeUpdate();
                }
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

                flight.setId(rs.getInt("flightid"));
                flight.setAirline(rs.getString("airline"));
                flight.setDuration(rs.getFloat("duration"));
                flight.setDepartureTime(rs.getTimestamp("departuretime"));
                flight.setDepartureLocationCode(rs.getInt("departurelocationcode"));
                flight.setArrivalLocationCode(rs.getInt("arrivallocationcode"));


                PricingInfo pricingInfo = pricingInfoDAO.getPricingInfo(flight.getId());
                flight.setPricingInfo(pricingInfo);

                Map<String,Integer> seatingInfo = getSeatingInfo(flight.getId());
                flight.setSeatingInfo(seatingInfo);
                flights.add(flight);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    @Override
    public Flight getFlightByID(int id) {
        String sql = "SELECT * FROM flights WHERE flightid = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            while(rs.next()){ // triggers only once. TODO: refactor
                Flight flight = new Flight();

                flight.setId(rs.getInt("flightid"));
                flight.setAirline(rs.getString("airline"));
                flight.setDuration(rs.getFloat("duration"));
                flight.setDepartureTime(rs.getTimestamp("departuretime"));
                flight.setDepartureLocationCode(rs.getInt("departurelocationcode"));
                flight.setArrivalLocationCode(rs.getInt("arrivallocationcode"));
                PricingInfo pricingInfo = pricingInfoDAO.getPricingInfo(flight.getId());
                flight.setPricingInfo(pricingInfo);

                Map<String,Integer> seatingInfo = getSeatingInfo(flight.getId());
                flight.setSeatingInfo(seatingInfo);
                return flight;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Flight> findFlightsByLocation(int locationCode) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights WHERE departurelocationcode = ? OR arrivallocationcode = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,locationCode);
            st.setInt(2,locationCode);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Flight flight = new Flight();

                flight.setId(rs.getInt("flightid"));
                flight.setAirline(rs.getString("airline"));
                flight.setDuration(rs.getFloat("duration"));
                flight.setDepartureTime(rs.getTimestamp("departuretime"));
                flight.setDepartureLocationCode(rs.getInt("departurelocationcode"));
                flight.setArrivalLocationCode(rs.getInt("arrivallocationcode"));
                PricingInfo pricingInfo = pricingInfoDAO.getPricingInfo(flight.getId());
                flight.setPricingInfo(pricingInfo);

                Map<String,Integer> seatingInfo = getSeatingInfo(flight.getId());
                flight.setSeatingInfo(seatingInfo);

                flights.add(flight);
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
        String sql = "INSERT INTO flights " +
                "(airline,duration,departuretime,departurelocationcode,arrivallocationcode,flightid)" +
                " VALUES " +
                "(?,?,?,?,?,?)";


        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,flight.getAirline());
                pstmt.setFloat(2,flight.getDuration());
                pstmt.setTimestamp(3,flight.getDepartureTime());
                pstmt.setInt(4,flight.getDepartureLocationCode());
                pstmt.setInt(5,flight.getArrivalLocationCode());
                pstmt.setInt(6,getLastID() + 1);
                pstmt.executeUpdate();

                // do these separately
                //saveSeatingInfo(flight);
                //pricingInfoDAO.savePricingInfo(flight.getPricingInfo());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateFlight(Flight flight) {
        String sql = "UPDATE flights SET " +
                "airline = ?, " +
                "duration = ?, " +
                "departuretime = ?, " +
                "departurelocationcode = ?, " +
                "arrivallocationcode = ? " +
                "WHERE flightid = ?";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, flight.getAirline());
            pstmt.setFloat(2,flight.getDuration());
            pstmt.setTimestamp(3,flight.getDepartureTime());
            pstmt.setInt(4,flight.getDepartureLocationCode());
            pstmt.setInt(5,flight.getArrivalLocationCode());
            pstmt.setInt(6,flight.getId());



            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pricingInfoDAO.updatePricingInfo(flight.getPricingInfo());
        updateSeatingInfo(flight);
    }

    @Override
    public void reserveSeats(int flightID, String seatCategory, int seatAmount) {
        Flight flight = getFlightByID(flightID);
        Map<String, Integer> seatingInfo = flight.getSeatingInfo();
        seatingInfo.put(seatCategory,seatingInfo.get(seatCategory) - seatAmount);
        flight.setSeatingInfo(seatingInfo);
        updateFlight(flight);
    }

    public void clearTables(){
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            {
                Statement st = conn.createStatement();
                st.execute("DELETE FROM flights");
                st.execute("DELETE FROM baseprices");
                st.execute("DELETE FROM promotions");
                st.execute("DELETE FROM seatinginfos");

            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private int getLastID(){
        String sql= "SELECT max(flightid) FROM flights";
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                return rs.getInt(1);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
