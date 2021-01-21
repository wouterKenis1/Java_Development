package com.vdab.controllers;

import com.vdab.DAO.UserDAO;
import com.vdab.models.Flight;
import com.vdab.models.User;
import com.vdab.services.UserService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;


    // region validation
    @RequestMapping(value="/validateUser",method = RequestMethod.GET)
    public @NotNull boolean validateUser(@RequestParam String username, @RequestParam String password){
        boolean validateUser = userService.validateUser(username, password);
        System.out.println(validateUser);
        return validateUser;
    }

    @RequestMapping(value="/validateUserExists",method = RequestMethod.GET)
    public @NotNull boolean validateUserExists(@RequestParam String username){
        return userService.validateUserExists(username);
    }



    // endregion

    // region getters
    @RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
    public @NotNull Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(value="/getAllUserStrings",method = RequestMethod.GET)
    public @NotNull Iterable<String> getAllUserStrings(){
        List<User> users = (ArrayList<User>) userService.getAllUsers();
        List<String> userStrings = new ArrayList<>();
        users.forEach(user -> {userStrings.add(user.getUsername());});
        return userStrings;
    }
    @RequestMapping(value="/getRolesForUser",method = RequestMethod.GET)
    public @NotNull Iterable<String> getRolesForUser(@RequestParam String username) {
        return userService.getRolesForUser(username);
    }

        // endregion

    // region setters
    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public @NotNull boolean saveUser(@RequestBody Map<String,String> data){
        User user = new User()
                .setUsername(data.get("username"))
                .setPassword(data.get("password"))
                .setAccessRoles(new Vector<>());
        userService.saveUser(user);
        return true;
    }

    @RequestMapping(value="/giveUserRole", method = RequestMethod.POST)
    public @NotNull boolean giveUserRole(@RequestBody Map<String,String> data){
        userService.giveUserAccessRole(data.get("username"),data.get("accessRole"));
        return true;
    }
    @RequestMapping(value="/removeUserRole", method = RequestMethod.POST)
    public @NotNull boolean removeUserRole(@RequestBody Map<String,String> data){
        userService.removeUserAccessRole(data.get("username"),data.get("accessRole"));
        return true;
    }
    // endregion

}
