package ru.job4j.oop;

public class Train implements Vehicles {
    @Override
    public void move() {
        System.out.println("Я - " + getClass().getSimpleName() + " . Я передвигаюсь строго по рельсам.");
    }

    @Override
    public void speed() {
        System.out.println("Я - " + getClass().getSimpleName() + " . Я быстрее автобуса, но медленее самолета.");
    }

    @Override
    public void price() {
        System.out.println("Я - " + getClass().getSimpleName() + " . Цена билета на поезд - средняя.");
    }
}
