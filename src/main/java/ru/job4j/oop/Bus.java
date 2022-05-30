package ru.job4j.oop;

public class Bus implements Vehicles {
    @Override
    public void move() {
        System.out.println("Я - " + getClass().getSimpleName() +  " . Я передвигаюсь по шоссе.");
    }

    @Override
    public void speed() {
        System.out.println("Я - " + getClass().getSimpleName() + " . Я медленнее поезда и самолета.");
    }

    @Override
    public void price() {
        System.out.println("Я - " + getClass().getSimpleName() + " . Билет на автобус стоит дешево.");
    }
}
