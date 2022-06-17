package ru.job4j.ex;

public class Fact {
    public static int fact(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be 1 or more.");
        }
        int rsl = 1;
        for (int i = 1; i <= number; i++) {
            rsl = rsl * i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println("Factorial is " + fact(-3));
    }
}
