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
    public boolean validateUser(String username, String password) {
        return userDAO.validateUser(username,password);
    }

    @Override
    public boolean validateUserExists(String username){
        List<User> users = (ArrayList<User>) getAllUsers();
        for(User user : users){
            if(user.getUsername() == username){
                return true;
            }
        }
        return false;
    }


    public void saveUser(User user){
        userDAO.saveUser(user);
    }

    @Override
    public void giveUserAccessRole(String username, String accessRole) {
        // test if role is present to prevent double permissions
        List<String> roles = (ArrayList<String>) getRolesForUser(username);
        if(!roles.contains(accessRole)){
            userDAO.insertRole(username, accessRole);
        }
    }

    @Override
    public void removeUserAccessRole(String username, String accessRole){
        userDAO.deleteRole(username,accessRole);
    }

}
