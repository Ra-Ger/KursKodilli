package com.kodilla.good.patterns.challenges.posComponents;

public class User {
    String name;
    int phoneNumber;

    public User(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
