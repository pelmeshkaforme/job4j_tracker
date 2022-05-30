package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("I am a bus and i am driving to home.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Qty of passengers in bus: " + passengers);
    }

    @Override
    public double refueling(double fuel) {
        double price = 1.23;
        return price * fuel;
    }
}
