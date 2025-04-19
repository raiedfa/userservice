package com.example.classProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class User {
    private int id;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String LastName;
    private String email;
    private String age;
    private String address;
    @JsonProperty(value = "join_date")
    private LocalDate joinDate;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String age, String address, LocalDate joiningDate) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
        this.joinDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joiningDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", joiningDate=" + joinDate +
                '}';
    }
}
