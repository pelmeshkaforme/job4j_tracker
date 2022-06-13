package ru.job4j.encapsulation;

public class Acount {
    int balance;

    public void addMoney(int money) {
        if (money > 0) {
            balance = balance + money;
        }
    }
}
