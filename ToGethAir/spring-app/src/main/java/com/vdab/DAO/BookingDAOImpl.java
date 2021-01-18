package com.vdab.DAO;

import com.vdab.App.DataBaseAccess;
import com.vdab.models.Booking;
import com.vdab.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {

    final private String url = DataBaseAccess.getUrl();
    final private String pass = DataBaseAccess.getPass();
    final private String user = DataBaseAccess.getUser();

    @Autowired
    FlightDAO flightDAO;

    @Override
    public void saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings (bookingid,flightid,seatamount,seatcategory,bookingprice,ispaid, username) VALUES (?,?,?,?,?,?,?)";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1,getLastID() + 1);
                pstmt.setInt(2,booking.getFlightID());
                pstmt.setInt(3,booking.getSeatAmount());
                pstmt.setString(4, booking.getSeatCategory());
                pstmt.setFloat(5,booking.getBookingPrice());
                pstmt.setBoolean(6, booking.isPaid());
                pstmt.setString(7, booking.getUser());

                pstmt.executeUpdate();

                flightDAO.reserveSeats(booking.getFlightID(), booking.getSeatCategory(), booking.getSeatAmount());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveBooking(int flightID, int seatAmount, String seatCategory, float bookingPrice, boolean payByEndorsement, boolean isPaid){
        Booking booking = new Booking()
                .setFlightID(flightID)
                .setSeatAmount(seatAmount)
                .setSeatCategory(seatCategory)
                .setBookingPrice(bookingPrice)
                .setPayByEndorsement(payByEndorsement)
                .setPaid(isPaid);
        saveBooking(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));
                booking.setUser(rs.getString("username"));

                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    private int getLastID(){
        String sql= "SELECT max(bookingid) FROM bookings";
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

    @Override
    public List<Booking> findBookingByFlightID(int flightID){
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE flightid = ?";
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,flightID);
            ResultSet rs = st.executeQuery();

            while(rs.next()){ // triggers only once. TODO: try to refactor
                 Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));
                booking.setUser(rs.getString("username"));

                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    @Override
    public List<Booking> findBookingBySeatAmount(int seatAmount) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE seatAmount = ?";
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,seatAmount);
            ResultSet rs = st.executeQuery();

            while(rs.next()){ // triggers only once. TODO: refactor
                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));
                booking.setUser(rs.getString("username"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    @Override
    public List<Booking> findBookingBySeatCategory(String seatCategory) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE seatcategory = ?";
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,seatCategory);
            ResultSet rs = st.executeQuery();

            while(rs.next()){ // triggers only once. TODO: refactor
                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));
                booking.setUser(rs.getString("username"));

                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    @Override
    public List<Booking> findBookingsByLocation(int locationCode) {
        List<Booking> bookings = new ArrayList<>();

        List<Flight> flights = flightDAO.findFlightsByLocation(locationCode);
        for(Flight flight : flights){
            bookings.addAll(findBookingByFlightID(flight.getId()));
        }

        return bookings;

    }

    @Override
    public List<Booking> findBookingsByDate(Timestamp date) {
        return null;    // TODO: implement
    }

    @Override
    public List<Booking> findBookingsByAirline(String airline) {
        return null;    // TODO: implement
    }

    @Override
    public void updateBooking(Booking booking){
        String sql = "UPDATE bookings " +
                "SET flightid = ?, seatamount = ?, seatcategory = ?, bookingprice = ?, ispaid = ?, username = ? " +
                "WHERE bookingid = ?";
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1,booking.getFlightID());
            st.setInt(2,booking.getSeatAmount());
            st.setString(3,booking.getSeatCategory());
            st.setFloat(4,booking.getBookingPrice());
            st.setBoolean(5,booking.isPaid());
            st.setInt(6,booking.getBookingID());
            st.setString(7,booking.getUser());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> findBookingsByUsername(String username){
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE username = ?";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()){
                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));
                booking.setUser(rs.getString("username"));

                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }


}
