package com.vdab.services;

import com.vdab.models.User;

public interface UserService {
    Iterable<User> getAllUsers();
    Iterable<String> getRolesForUser(String username);
    boolean validateUser(String username, String password);
    boolean validateUserExists(String username);

    void saveUser(User user);
    void giveUserAccessRole(String user, String accessRole);
    void removeUserAccessRole(String user, String accessRole);
}
