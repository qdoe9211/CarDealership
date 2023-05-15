package org.yearup.services;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {
    private String filepath;

    ArrayList<Dealership> dealerships = new ArrayList<>();

    public DealershipFileManager(String filepath) { this.filepath = filepath; }

    public ArrayList<Dealership> getDealership() throws Exception {

        ArrayList<Dealership> vehicles = new ArrayList<>();

        try (FileReader reader = new FileReader(this.filepath);
             Scanner scanner = new Scanner(reader)
        ) {
            scanner.nextLine();

            while(scanner.hasNext()) {

                String line = scanner.nextLine();
                String[] columns = line.split("\\|");
                int vin = Integer.parseInt(columns[0]);
                int year = Integer.parseInt(columns[1]);
                String make = columns[2];
                String model = columns[3];
                String color = columns[4];
                String vehicleType = columns[5];
                int odometer = Integer.parseInt(columns[6]);
                double price = Double.parseDouble(columns[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer,price);
                vehicles.add(vehicle);
            }
        }catch (IOException ex) {}
        return vehicles;
    }



    public void saveDealership() {}
}
