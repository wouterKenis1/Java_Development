package com.vdab.DAO;

import com.vdab.App.DataBaseAccess;
import com.vdab.models.Booking;
import com.vdab.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Repository
public class UserDAOImpl implements UserDAO {

    final private String url = DataBaseAccess.getUrl();
    final private String pass = DataBaseAccess.getPass();
    final private String user = DataBaseAccess.getUser();

    @Autowired
    BookingDAO bookingDAO;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);   //TODO: add table users
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                Vector<String> accessRoles = new Vector<>();
                accessRoles.addAll(getRoles(user.getUsername()));
                user.setAccessRoles(accessRoles);

                Vector<Integer> bookingIDs = new Vector<>();
                bookingIDs.addAll(getBookingIDs(user.getUsername()));
                user.setBookingIDs(bookingIDs);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<String> getRoles(String username) {
        List<String> accessRoles = new ArrayList<>();
        String sql = "SELECT role FROM accessroles WHERE username = ?"; //TODO: add table accessroles

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()) {
                accessRoles.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessRoles;
    }

    @Override
    public List<Integer> getBookingIDs(String username) {
        List<Integer> bookingIDs = new ArrayList<>();
        String sql = "SELECT bookingID FROM bookings WHERE username = ?"; //TODO: add field username to bookings

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()) {
                bookingIDs.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingIDs;
    }

    @Override
    public List<Booking> getBookings(String username) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE username = ?"; //TODO: add field username to bookings

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()) {
                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("bookingid"));
                booking.setFlightID(rs.getInt("flightid"));
                booking.setSeatAmount((rs.getInt("seatamount")));
                booking.setSeatCategory(rs.getString("seatcategory"));
                booking.setBookingPrice(rs.getFloat("bookingprice"));
                booking.setPaid(rs.getBoolean("ispaid"));

                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public boolean validateUser(String username, String password) {

        String sql = "SELECT password FROM users WHERE username = ?"; //TODO: add table users

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery(sql);

            String dataBasePassword = rs.getString(1);
            return (User.hashPass(password) == dataBasePassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void saveUser(User user) {
            String usersSql = "INSERT INTO users (username,password)" +
                    "VALUES (?,?)";

            String accessSql = "INSERT INTO accessroles (id,username,role)" +
                    "VALUES (?,?,?)";
        try{
            Connection conn = DriverManager.getConnection(url,this.user,pass);
            // save table users
            PreparedStatement pstmt = conn.prepareStatement(usersSql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.executeUpdate();
            // save table accesssroles
            pstmt = conn.prepareStatement(accessSql);
            pstmt.setInt(1, getLastRolesIndex() + 1);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.executeUpdate();

            // a new user should not have any bookings yet!

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user) {
        String usersSql = "UPDATE users " +
                "SET password=? " +
                "WHERE username=?";


        try{
            Connection conn = DriverManager.getConnection(url,this.user,pass);
            // update table users
            PreparedStatement pstmt = conn.prepareStatement(usersSql);
            pstmt.setString(1,user.getPassword());
            pstmt.setString(2,user.getUsername());
            pstmt.executeUpdate();

            updateUserRoles(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    int getLastRolesIndex(){
        String sql = "SELECT max(id) FROM accessroles";
        try{
            Connection conn = DriverManager.getConnection(url,this.user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updateUserRoles(User user){

        List<String> dataBaseRoles = getRoles(user.getUsername());
        List<String> userRoles = user.getAccessRoles();
        String username = user.getUsername();
        // remove outdated roles
        for(String role : dataBaseRoles){
            if(!userRoles.contains(role)){
                deleteRole(username, role);
            }
        }
        // insert new roles
        for(String role : userRoles) {
            if (!dataBaseRoles.contains((role))) {
                insertRole(username, role);
            }
        }
    }

    void deleteRole(String username, String role) {
        String deleteSql = "DELETE FROM accessroles " +
                "WHERE username = ? AND role = ?";
        try {
            Connection conn = DriverManager.getConnection(url, this.user, pass);
            // update table users
            PreparedStatement pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, username);
            pstmt.setString(2, role);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertRole(String username, String role){
        String deleteSql = "INSERT INTO accessroles (id,username,role)" +
                " VALUES (?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, this.user, pass);
            // update table users
            PreparedStatement pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1,getLastRolesIndex() + 1);
            pstmt.setString(2, username);
            pstmt.setString(3, role);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
