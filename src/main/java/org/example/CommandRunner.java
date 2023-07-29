package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandRunner {

    protected static int selection;
    protected String vehicleType;
    private static Scanner scanner = new Scanner(System.in);

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public static void main(String[] args) {
Parking parking = new Parking();
        System.out.println("Welcome to our car park");

        ArrayList<Spot> motorbikes = new ArrayList<>(10);
        ArrayList<Spot> cars = new ArrayList<>(48);
        ArrayList<Spot> vans = new ArrayList<>(10);

        for (int i = 0; i < 3; i++) {
            motorbikes.add(new Spot(1, false)); // Category 1 represents motorbikes
            vans.add(new Spot(2, false)); // Category 2 represents vans
        }

        for (int i = 0; i < 48; i++) {
            cars.add(new Spot(3, false)); // Category 3 represents cars
        }

        while (selection != 6) {
            int carSpaces = Parking.checkIfAvailableSpaces(cars);
            int vanSpaces = Parking.checkIfAvailableSpaces(vans);
            int motorSpaces = Parking.checkIfAvailableSpaces(motorbikes);

            System.out.println("Please select an option: ");
            System.out.println("1: List all spots");
            System.out.println("2: List motorbike spots");
            System.out.println("3: List van spots");
            System.out.println("4: List car spots");
            System.out.println("5: Park a vehicle");
            System.out.println("6: Exit the car park");

            int input = scanner.nextInt();
            selection = input;

            switch (input) {
                case 1:


                    System.out.println("Available car spaces: " + carSpaces );
                    System.out.println("Available van spaces: " + vanSpaces);
                    System.out.println("Available motorbike spaces: " + motorSpaces);
                    break;

                case 2:

                    System.out.println("Available only for motorbike spaces: " + motorSpaces);
                    System.out.println("Available spaces for motorbikes: " + (motorSpaces+vanSpaces+carSpaces));
                    break;

                case 3:

                    System.out.println("Available van spaces: " + vanSpaces);
                    System.out.println("Available spaces for vans: " + (vanSpaces+(carSpaces/3)));
                    break;

                case 4:
                    System.out.println("Available car spaces: " + carSpaces);
                    System.out.println("Available car spaces: " + (carSpaces + vanSpaces));
                    break;

                case 5:
                    System.out.println("Enter the category (1 for motorbike, 2 for van, 3 for car): ");
                    int category = scanner.nextInt();

                    if (category < 1 || category > 3) {
                        System.out.println("Invalid category. Please try again.");
                        break;
                    }

                    ArrayList<Spot> parkingLot = null;
                    ArrayList<Spot> alternativeParkingLot = new ArrayList<>();

                    String vehicleType = "";

                    switch (category) {
                        case 1:
                            parkingLot = motorbikes;
                            alternativeParkingLot.addAll(vans);
                            alternativeParkingLot.addAll(cars);
                            vehicleType = "motorbike";
                            break;
                        case 2:
                            parkingLot = vans;
                            alternativeParkingLot.addAll(cars);
                            vehicleType = "van";
                            break;
                        case 3:
                            parkingLot = cars;
                            alternativeParkingLot.addAll(vans);
                            vehicleType = "car";
                            break;
                    }

                    int availableSpaces = Parking.checkIfAvailableSpaces(parkingLot);

                    if (availableSpaces > 0) {
                        for (Spot spot : parkingLot) {
                            if (!spot.isTaken()) {
                                spot.setTaken(true);
                                System.out.println("Parked a " + vehicleType + "  in spot " + spot.getCategory());
                                break;
                            }
                        }
                    } else if (availableSpaces <= 0 && (alternativeParkingLot.size() > 0) ) {
                        System.out.println("No available spots for " + vehicleType + " in the " + vehicleType + " section");
                        System.out.println("Do you want to park in a different section?");
                        System.out.println("1: Yes");
                        System.out.println("2: No");

                        int userInput = scanner.nextInt();
                        switch (userInput) {
                            case 1:
                                if(vehicleType == "motorbike" && cars.size()>0) {
                                    for (Spot spot : cars) {
                                        if (!spot.isTaken()) {
                                            spot.setTaken(true);
                                            System.out.println("Parked a " + vehicleType + "  in spot for cars");
                                        break;

                                         }}} else if(vehicleType == "motorbike" && cars.size()<=0 && vans.size()>0){
                                            for (Spot spot : vans) {
                                                if (!spot.isTaken()) {
                                                    spot.setTaken(true);
                                                    System.out.println("Parked a " + vehicleType + "  in spot for vans");
                                                    break;


                                                }}

                                } else if(vehicleType == "car" && vans.size()>0){
                                    for (Spot spot : vans) {
                                        if (!spot.isTaken()) {
                                            spot.setTaken(true);
                                            System.out.println("Parked a " + vehicleType + "  in spot for vans");
                                            break;

                                        }}

                                } else if(vehicleType == "van" && cars.size()>3){
                                    int total = 0;
                                    for (int i = 0; i < cars.size(); i++) {


                                            if (!cars.get(i).isTaken() && total != 3) {
                                                cars.get(i).setTaken(true);
                                                total++;

                                            } else if(total == 3){
                                                System.out.println("Parked a " + vehicleType + "  in spot for vans");
                                                break;


                                        }


                                    }



                                }


                            case 2:
                                break;

                        }

                    } else {

                        System.out.println("No available spots for " + vehicleType + " in the parking lot.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the car park. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }
}
