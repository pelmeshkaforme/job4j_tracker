package ru.job4j.oop;

public class Aircraft implements Vehicles {
    @Override
    public void move() {
        System.out.println("Я - " + getClass().getSimpleName() + ". Я летаю в небе.");
    }

    @Override
    public void speed() {
        System.out.println("Я - " + getClass().getSimpleName() + ". У меня самая высокая скорость.");
    }

    @Override
    public void price() {
        System.out.println("Я - " + getClass().getSimpleName() + ". Летать на мне очень дорого.");
    }
}
