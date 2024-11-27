package com.example.demo.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository UserRepository;

    // Create
    public User createUser (String name, Integer age, LocalDate dob, String email, double height, double weight) {
        User User = new User(name, age, dob, email, height, weight);
        return UserRepository.save(User);
    }

    // Read ID
    public Optional<User> findUserById (String Id) {
        return UserRepository.findById(Id);
    }

    // Read All Users
    public List<User> findAllUsers() {
        return UserRepository.findAll();
    }

    // Find User by Name
    public Optional<User> findUserByName (String name) {
        return UserRepository.findUserByName(name);
    }

    // Find User by E-mail
    public Optional<User> findUserByEmail(String email) {
        return UserRepository.findUserByEmail(email);
    }

    // Count Users by Age
    public long countUserByAge () {
        return UserRepository.count();
    }

    // Update User
    public User updateUser (String id, User updatedUser) {
        return UserRepository.findById(id).map(User -> {
            User.setName(updatedUser.getName());
            User.setAge(updatedUser.getAge());
            User.setEmail(updatedUser.getEmail());
            User.setDob(updatedUser.getDob());
            return UserRepository.save(User);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Delete User
    public void deleteUser (String id) {
        UserRepository.deleteById(id);
    }

}