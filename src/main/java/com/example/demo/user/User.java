package com.example.demo.user;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("User") // Indicates its a class that will be registered as a document inside a collection in MongoDB.
public class User {

    @MongoId
    private String id;
    private String name;
    private String email;
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private double height;
    private double weight;

    // Collection Structure
    private ArrayList<String> activityLog = new ArrayList<>();

    public User() {
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

    // Getters and Setters for the existing fields
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

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getters and Setters for activityLog
    public ArrayList<String> getActivityLog() {
        return activityLog;
    }

    public void setActivityLog(ArrayList<String> activityLog) {
        this.activityLog = activityLog;
    }

    // Utility method to add an activity to the log
    public void addActivity(String activity) {
        this.activityLog.add(activity);
    }

    // Utility method to clear the activity log
    public void clearActivityLog() {
        this.activityLog.clear();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", height=" + height +
                ", weight=" + weight +
                ", activityLog=" + activityLog +
                '}';
    }
}
