package org.yearup.models;

import java.util.ArrayList;

public class Dealership {

    private ArrayList<Vehicle> vehicles;
    private String name;
    private String address;
    private String phoneNumber;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber, ArrayList<Vehicle> inventory)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public ArrayList<Vehicle> getAllVehicles() { return vehicles; }

    public void addVehicle() {}

    public ArrayList<Vehicle> findVehiclesByPriceRange(double min, double max) {

        ArrayList<Vehicle> inventory = new ArrayList<>();

        for(Vehicle vehicle: inventory) {

            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                inventory.add(vehicle);
            }
        }

        return inventory;
    }

    public ArrayList<Vehicle> findVehiclesByMakeModel(String make, String model) {

        ArrayList<Vehicle> inventory = new ArrayList<>();

        for(Vehicle vehicle: inventory) {

            if(vehicle.getMake().contains(make) && vehicle.getModel().contains(model)) {

                inventory.add(vehicle);
            }
        }

        return inventory;
    }

}


