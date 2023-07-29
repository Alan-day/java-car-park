package org.example;

import org.example.Spot;

import java.util.ArrayList;

public class Parking {
    // Assuming the Spot class has a method called isTaken() that returns a boolean

    public static int checkIfAvailableSpaces(ArrayList<Spot> vehicles) {
        ArrayList<Spot> list = new ArrayList<>();

        for (Spot vehicle : vehicles) {
            if (!vehicle.isTaken()) {
                list.add(vehicle);
            }
        }

        int spaces = list.size();
        return spaces;
    }




//    public static int checkIfAvailableSpaces(ArrayList<Spot> vehicles) {
//        ArrayList<Spot> list = new ArrayList<>();
//
//        for (Spot vehicle : vehicles) {
//            if (!vehicle.isTaken()) {
//                list.add(vehicle);
//            }
//        }
//
//        int spaces = list.size();
//        return spaces;
//    }
    public static int checkAllSpaces(int cars, int vans, int motors) {
        int spaces = cars + vans + motors;
        System.out.println("Total parking spaces: " + spaces);
        return spaces;
    }

    public static void main(String[] args) {
//        Spot spot = new Spot();
//
//        ArrayList<Spot> motorbikes = new ArrayList<>(10);
//        ArrayList<Spot> cars = new ArrayList<>(48);
//        ArrayList<Spot> vans = new ArrayList<>(10);
//
//        for (int i = 0; i < 10; i++) {
//            motorbikes.add(spot);
//            vans.add(spot);
//        }
//
//        for (int i = 0; i < 48; i++) {
//            cars.add(spot);
//        }
//
//        int carSpaces = checkIfAvailableSpaces(cars);
//        int vanSpaces = checkIfAvailableSpaces(vans);
//        int motorSpaces = checkIfAvailableSpaces(motorbikes);
//        checkAllSpaces(carSpaces, vanSpaces, motorSpaces);
    }
}
