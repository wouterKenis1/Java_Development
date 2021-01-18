package com.vdab.controllers;

import com.vdab.DAO.UserDAO;
import com.vdab.models.Flight;
import com.vdab.models.User;
import com.vdab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;


    // region validation
    @RequestMapping(value="/validateUser",method = RequestMethod.GET)
    public @NotNull Iterable<Boolean> getAllFlights(@RequestParam String username, @RequestParam String password){
        return userService.validateUser(username,password);
    }
    // endregion

    // region getters
    @RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
    public @NotNull Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }
    // endregion

    // region setters

    // endregion

}
