package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @GetMapping("/{id}")
    public Optional<User> findUserById (String id) {
        return UserService.findUserById(id);
    }
    
    // Find User by Email
    @GetMapping("/email/{email}")
    public Optional<User> findUserByEmail (String email) {
        return UserService.findUserByEmail(email);
    }

    // Create User
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser (@RequestBody User user, @RequestHeader("Content-Type") String contentType) {

        // Check if the content-type is Application/Json
        if(!"application/json".equals(contentType)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid content type. Expected application/json.");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(UserService.createUser(user.getName(), user.getAge(), user.getDob(), user.getEmail(), user.getHeight(), user.getWeight()));
        }
        // return UserService.createUser(User.getName(), User.getAge(), User.getDob(), User.getEmail(), User.getHeight(), User.getWeight());

    }

    // Count Users by Age
    @GetMapping("/countByAge")
    public long countUserByAge () {
        return UserService.countUserByAge();
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser (String id, User updatedUser) {
        return UserService.updateUser(id, updatedUser);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public void deleteUser (String id) {
        UserService.deleteUser(id);
    }
}
