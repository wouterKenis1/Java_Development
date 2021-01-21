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
            Connection conn = DriverManager.getConnection(url,user,pass);   //DONE: add table users
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                Vector<String> accessRoles = new Vector<>();
                accessRoles.addAll(getRoles(user.getUsername()));
                user.setAccessRoles(accessRoles);

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
        String sql = "SELECT role FROM accessroles WHERE username = ?"; //DONE: add table accessroles

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                accessRoles.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessRoles;
    }

    @Override
    public boolean validateUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ?"; //DONE: add table users

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();

            String dataBasePassword = "";
            while(rs.next()){
                dataBasePassword = rs.getString("password");
            }
            System.out.println(User.hashPass(password) + "|" + dataBasePassword);
            return (User.hashPass(password).equals(dataBasePassword));

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
            user.getAccessRoles().forEach(role ->{
                insertRole(user.getUsername(),role);
            });

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
        return 0;
    }

    public void updateUserRoles(User user){ // better to use deleteRole/insertRole instead

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


    public void deleteRole(String username, String role) {
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

    @Override
    public void overrideMargins(float overrideAmount) {

    }

    public void insertRole(String username, String role){   //NOTE: double permissions possible
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
