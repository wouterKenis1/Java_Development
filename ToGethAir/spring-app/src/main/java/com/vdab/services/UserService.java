package com.vdab.services;

import com.vdab.models.User;

public interface UserService {
    Iterable<User> getAllUsers();
    Iterable<String> getRolesForUser(String username);
    Iterable<Boolean> validateUser(String username, String password);
}
