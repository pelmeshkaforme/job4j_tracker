package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 11;
        System.out.println("Игра началась");
        while (count > 0) {
            System.out.println("Введите число спичек от 1 до 3");
            int select = Integer.parseInt(scanner.nextLine());
            while (select < 1 || select > 3 || select > count) {
                System.out.println("Ошибка.повторите ввод");
                select = Integer.parseInt(scanner.nextLine());
            }
            count = count - select;
            if (count == 0) {
                System.out.println("Ты забрал последние спички, а значит - Ты победил!");
            } else {
            System.out.println("Я забрал " + select + " спичек. Теперь твой ход. Спичек осталось - " + count);
            }
        }
    }
}
