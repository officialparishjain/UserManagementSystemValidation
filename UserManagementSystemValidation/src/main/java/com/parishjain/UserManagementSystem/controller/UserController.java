package com.parishjain.UserManagementSystem.controller;

import com.parishjain.UserManagementSystem.models.User;
import com.parishjain.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/userManagement")
public class UserController {

       @Autowired
       UserService userService;

    // Add User
    @PostMapping("/addUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addUserToList(user);
    }

    // GetAll Users
    @GetMapping(value = "/user/all")
    public List<User> getAllUserList(){
        return userService.getAllUserInList();
    }

    // Get User By id
    @GetMapping(value = "/getUserById/{user_id}")
    public User getUserByUserId(@PathVariable String user_id){
       return userService.getUserById(user_id);
    }

    // Delete User
    @DeleteMapping(value = "/deleteUser/{user_id}")
    public String deleteUserById(@PathVariable String user_id){
        return userService.deleteUserById(user_id);
    }


    // Update User
    @PutMapping(value = "/updateUserInfo")
    public String updateUserDetails(@RequestBody User user){
        return userService.updateUserInformation(user);
    }

}
