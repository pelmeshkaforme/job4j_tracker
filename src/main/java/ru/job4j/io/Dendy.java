package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Игры.");
            System.out.println("1. Танчики.");
            System.out.println("2. Супер Марио.");
            System.out.println("3. Выйти.");
            System.out.println("Введите пункт для выбора игры.");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 3) {
                run = false;
                System.out.println("Выход из программы...");
            } else if (select == 1) {
                System.out.println("Танчики загружаются...");
            } else if (select == 2) {
                System.out.println("Супер Марио загружается...");
            } else {
                System.out.println("Такой игра нет в списке.");
            }
        }
    }
}
