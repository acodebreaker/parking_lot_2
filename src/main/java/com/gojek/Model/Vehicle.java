package com.gojek.Model;

public class Vehicle {
    String color;
    String registrationNumber;

    public Vehicle(String color, String registrationNumber)
    {
        this.color=color;
        this.registrationNumber=registrationNumber;
    }

    public String getColor() {
        return color;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }


}
