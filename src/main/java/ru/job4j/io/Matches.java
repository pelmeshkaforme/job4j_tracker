package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра 11 началась.");
        int count = 11;
        boolean turn = true;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + ", введите число спичек от 1 до 3.");
            int select = Integer.parseInt(scanner.nextLine());
            while (select < 1 || select > 3 || select > count) {
                System.out.println("Ошибка.повторите ввод");
                select = Integer.parseInt(scanner.nextLine());
            }
            count = count - select;
            System.out.println("На столе осталость " + count + " спичек.");
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок.");
        } else {
            System.out.println("Выиграл второй игрок.");
        }
    }
}
