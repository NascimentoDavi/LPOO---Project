package com.example.demo.user;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("User")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private double height;
    private double weight;

    public User () {
    }

    public User(
        String id, 
        String name, 
        Integer age, 
        LocalDate dob, 
        String email,
        double height,
        double weight
        ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.height = height;
        this.weight = weight;
    }

    public User(
        String name, 
        Integer age, 
        LocalDate dob, 
        String email,
        double height,
        double weight
        ) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.height = height;
        this.weight = weight;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight () {
        return this.height;
    }

    public double getWeight () {
        return this.weight;
    }

    public void setHeight (double h) {
        this.height = h;
    }

    public void setWeight (double w) {
        this.weight = w;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
