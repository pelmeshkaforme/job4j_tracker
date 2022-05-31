package ru.job4j.io;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Добро пожаловать. Как вас зовут?");
        String name = scanner.nextLine();
        System.out.println(name + ", Я рад вас видеть");
    }
}
