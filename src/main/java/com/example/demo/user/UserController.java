package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private UserService UserService;

    // Return all Users
    @GetMapping("/all")
    public List<User> getAllUsers () {
        return UserService.findAllUsers();
    }

    // Find User by Id
    public Optional<User> findUserById (String id) {
        return UserService.findUserById(id);
    }
    
    // Find User by Email
    public Optional<User> findUserByEmail (String email) {
        return UserService.findUserByEmail(email);
    }

    // Create User
    @PostMapping("/createUser")
    public User createUser (@RequestBody User User) {
        return UserService.createUser(User.getName(), User.getAge(), User.getDob(), User.getEmail(), User.getHeight(), User.getWeight());
    }

    // Count Users by Age
    public long countUserByAge () {
        return UserService.countUserByAge();
    }

    // Update User
    public User updateUser (String id, User updatedUser) {
        return UserService.updateUser(id, updatedUser);
    }

    // Delete User
    public void deleteUser (String id) {
        UserService.deleteUser(id);
    }
}
