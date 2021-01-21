package com.vdab.models;

import java.util.Vector;

public class User {
    String username;
    String password;
    Vector<String> accessRoles;

    public static String hashPass(String passwordToHash){
        return passwordToHash;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = hashPass(password);
        return this;
    }


    public Vector<String> getAccessRoles() {
        return accessRoles;
    }

    public User setAccessRoles(Vector<String> accessRoles) {
        this.accessRoles = accessRoles;
        return this;
    }
}
