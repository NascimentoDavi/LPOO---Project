package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepository extends MongoRepository<Student, String> {

    // Find a Student by name
    @Query("{name:'?0'}")
    Optional<Student> findStudentByName(String name);

    // Find Student by email, nly returning the name, age and dateofbirth fields
    @Query(value="{email:'?0'}", fields="{'name' : 1, 'age' : 1, 'dob' : 1}")
    Optional<Student> findStudentByEmail(String email);

    @Query(value = "{age: ?0}", count = true)
    long countByAge(Integer age);

}
