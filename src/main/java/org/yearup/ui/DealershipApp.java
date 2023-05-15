package org.yearup.ui;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;
import org.yearup.services.DealershipFileManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipApp {

    private Dealership dealership;
    private Vehicle vehicle;
    DealershipFileManager dealershipManager = new DealershipFileManager("data\\inventory.csv");
    ArrayList<Dealership> dealerships;
    ArrayList<Dealership> vehicles;


    public int run() throws Exception{
        init();

        int command;
        Scanner scanner = new Scanner(System.in);

            do {
                displayHomeScreen();
                command = scanner.nextInt();
                switch (command) {
                    case 1:
                        processGetAllVehiclesRequest();
                        break;
                    case 2:
                        processGetByPriceRequest();
                        break;
                    case 3:
                        processGetByMakeModelRequest();
                        break;
                    case 4:
                        processAddVehicleRequest();
                        break;
                    case 0:
                        System.out.println("Thank you! Have a great day!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } while (command != 0);
        return command;
    }
    private void init() throws Exception {
        dealerships = dealershipManager.getDealership();
    }

    public static int displayHomeScreen() {

        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println(" 1 - List All Vehicles");
        System.out.println(" 2 - Find Vehicles Within A Price Range");
        System.out.println(" 3 - Find Vehicles By Make/Model");
        System.out.println(" 4 - Add a Vehicle");
        System.out.println(" 0 - Exit Dealership");
        System.out.println("Enter your option: ");

        return 0;
    }

    public ArrayList<Vehicle> processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Vin|Year|Make|Model|Color|Vehicle Type|Odometer|Price");
        System.out.println("------------------------------------------------------");


        try (FileReader reader = new FileReader("date\\inventory.csv");
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

    public void processGetByPriceRequest() {


    }

    public void processGetByMakeModelRequest() {}

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("ADD A VEHICLE");
        System.out.println("----------------");
        System.out.println("Enter the Vehicle 5 digits VIN ");
        int vin = scanner.nextInt();
        System.out.println("Enter the year of the vehicle: ");
        int year = scanner.nextInt();
        System.out.println("Enter the Make of the vehicle: ");
        String make = scanner.nextLine();
        System.out.println("Enter the Model of the vehicle: ");
        String model = scanner.nextLine();
        System.out.println("Enter the color of the vehicle: ");
        String color = scanner.nextLine();
        System.out.println("Enter the vehicle type (i.e Sedan, SUV, Truck): ");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter the odometer reading: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter the price of the vehicle: ");
        double price = scanner.nextDouble();

        Dealership vehicles = new Dealership(vin, year, make, model, color, vehicleType, odometer, price);
        dealerships.add(vehicles);

        FileWriter writer = new FileWriter("data\\inventory.csv");
        writer.write("\n" + )
    }



}
