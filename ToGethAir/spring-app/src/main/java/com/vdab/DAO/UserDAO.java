package com.vdab.DAO;

import com.vdab.models.Booking;
import com.vdab.models.User;

import java.util.List;
import java.util.Vector;

public interface UserDAO {

    List<User> getAllUsers();
    List<String> getRoles(String username);
    List<Integer> getBookingIDs(String username);
    List<Booking> getBookings(String username);
    boolean validateUser(String username, String password);

    void saveUser(User user);
    void updateUser(User user);
    void updateUserRoles(User user);

}
