package org.yearup.models;

import java.util.ArrayList;

public class Dealership {

    private ArrayList<Vehicle> vehicles;
    private String name;
    private String address;
    private String phoneNumber;

    public Dealership(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vehicles = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public ArrayList<Vehicle> getAllVehicles() { return vehicles; }

    public void addVehicle() {}

    public ArrayList<Vehicle> findVehiclesByPriceRange(double price) { return null; }

    public ArrayList<Vehicle> findVehiclesByMakeModel(String make, String model) { return null; }

}


