package org.yearup.services;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {

    private Dealership dealership;

    public DealershipFileManager(Dealership dealership) {
        this.dealership = dealership;
    }

    public DealershipFileManager() {

    }

    public Dealership getDealership() {


        try (FileReader reader = new FileReader("inventory.csv");
             Scanner scanner = new Scanner(reader)
        ) {

            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            String name = columns[0];
            String address = columns[1];
            String phoneNumber = columns[2];

            ArrayList<Vehicle> inventory = new ArrayList<>();
            while (scanner.hasNext()) {

                line = scanner.nextLine();
                columns = line.split("\\|");
                int vin = Integer.parseInt(columns[0]);
                int year = Integer.parseInt(columns[1]);
                String make = columns[2];
                String model = columns[3];
                String color = columns[4];
                String vehicleType = columns[5];
                int odometer = Integer.parseInt(columns[6]);
                double price = Double.parseDouble(columns[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer, price);
                inventory.add(vehicle);
            }

            dealership = new Dealership(name, address, phoneNumber, inventory);
        } catch (IOException e) {}

        return dealership;
    }

    public ArrayList<Vehicle> processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public void saveDealership(Dealership dealership) throws Exception {

        FileWriter writer = new FileWriter("inventory.csv");
        writer.write("\n" + dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
        writer.close();

    }
}
