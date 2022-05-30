package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Введите номер пункта меню");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=====Add item menu=====");
                System.out.println("Fill item name");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавления заявка - " + item);
            } else if (select == 1) {
                System.out.println("=====Menu show all items=====");
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("Пока еще нет ни одной заявки");
                } else {
                    for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item", "Delete item", "Find item by id",
                "Find items by name", "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + "." + menu[i]);
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);
        new StartUI().init(scanner, tracker);
    }
}
