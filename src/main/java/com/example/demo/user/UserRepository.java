package com.example.demo.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    // Find a User by name
    @Query("{name:'?0'}")
    Optional<User> findUserByName(String name);

    // Find User by email, nly returning the name, age and dateofbirth fields
    @Query(value="{email:'?0'}", fields="{'name' : 1, 'age' : 1, 'dob' : 1}")
    Optional<User> findUserByEmail(String email);

    @Query(value = "{age: ?0}", count = true)
    long countByAge(Integer age);

}
