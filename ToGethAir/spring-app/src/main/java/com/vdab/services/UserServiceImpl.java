package com.vdab.services;

import com.vdab.DAO.UserDAO;
import com.vdab.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Iterable<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public Iterable<String> getRolesForUser(String username) {
        return userDAO.getRoles(username);
    }

    @Override
    public Iterable<Boolean> validateUser(String username, String password) {
        List<Boolean> returnValue = new ArrayList<Boolean>() ;
        returnValue.add(userDAO.validateUser(username,password));
        return returnValue;
    }
}
