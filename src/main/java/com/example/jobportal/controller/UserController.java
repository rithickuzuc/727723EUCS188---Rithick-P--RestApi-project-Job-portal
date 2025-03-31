package com.example.jobportal.controller;


import com.example.jobportal.models.User;
import com.example.jobportal.service.Userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

     Userservice userService;

    
    public UserController(Userservice userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<com.example.jobportal.models.User> getAllUsers() {
        return userService.getuser();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<com.example.jobportal.models.User> getUserById(@PathVariable int id) {
        return userService.getuserbyid(id);
    }

    // Add a new user
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.adduser(user);
    }

    // Update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.updatUser(user, id);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "User deleted successfully!";
    }
}