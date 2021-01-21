package com.vdab.DAO;

import com.vdab.models.Booking;
import com.vdab.models.User;

import java.util.List;
import java.util.Vector;

public interface UserDAO {

    List<User> getAllUsers();
    List<String> getRoles(String username);

    boolean validateUser(String username, String password);

    void saveUser(User user);
    void updateUser(User user);
    void updateUserRoles(User user);

    void insertRole(String user, String role);
    void deleteRole(String user, String role);

    void overrideMargins(float overrideAmount);

}
