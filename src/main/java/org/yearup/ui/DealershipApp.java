package org.yearup.ui;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;
import org.yearup.services.DealershipFileManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipApp {

    Scanner scanner = new Scanner(System.in);

    private DealershipFileManager fileManager;
    private Dealership dealership;
    ArrayList<Vehicle> dealerships = new ArrayList<>();

    public DealershipApp(){
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public int run() throws Exception{

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

        System.out.println("All Vehicles");
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println("Vin|Year|Make|Model|Color|Vehicle Type|Odometer|Price");
        System.out.println("------------------------------------------------------");


        try (FileReader reader = new FileReader("inventory.csv");
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
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Find Vehicles By Price");
        System.out.println("------------------------");
        System.out.println("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();

        for (Vehicle vehicle: dealerships) {
            double price = vehicle.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                System.out.println(vehicle.getPrice());
            }
        }
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Find Vehicles By Make/Model");
        System.out.println("-----------------------------");
        System.out.println("Enter the Make of the vehicle: ");
        String make = scanner.nextLine();
        System.out.println("Enter the Model of the vehicle: ");
        String model = scanner.nextLine();

        for (Vehicle vehicle: dealerships) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                System.out.println(vehicle.getMake() + " " + vehicle.getModel());
            }
        }
    }

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

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealerships.add(vehicle);

        System.out.println();
        System.out.println("Vehicle has been added: \n" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getColor() + "|" + vehicle.getVehicleType() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());

    }

}
