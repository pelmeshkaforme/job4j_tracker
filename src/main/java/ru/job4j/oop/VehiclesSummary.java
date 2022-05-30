package ru.job4j.oop;

public class VehiclesSummary {
    public static void main(String[] args) {
        Vehicles aircraft1 = new Aircraft();
        Vehicles aircraft2 = new Aircraft();
        Vehicles train1 = new Train();
        Vehicles train2 = new Train();
        Vehicles bus1 = new Bus();
        Vehicles bus2 = new Bus();
        Vehicles[] vehicles = {aircraft1, aircraft2, train1, train2, bus1, bus2};
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].move();
            vehicles[i].speed();
            vehicles[i].price();
        }
    }
}
