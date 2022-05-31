package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Введите номер пункта меню");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=====Add item menu=====");
                System.out.print("Fill item name");
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
                    for (Item item : items) {
                    System.out.println(item);
                    }
                }
            } else if (select == 2) {
                System.out.println("=====Edit item menu=====");
                System.out.print("Введите id заявки, которую вы хотите изменить");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите новое имя заявки, которую вы хотите изменить");
                String name = scanner.nextLine();
                Item item = new Item(id, name);
                if (tracker.replace(id, item)) {
                System.out.println("Имя заявки с id " + id + " успешно изменено на " + name);
                } else {
                    System.out.println("Заявки с введенным ид не существует");
                }
            } else if (select == 3) {
                System.out.println("=====Delete item menu=====");
                System.out.print("Введите номер id, которое требуется удалить");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка с id " + id + " успешно удалена.");
                } else {
                    System.out.println("Заявки с таким id не существует.");
                }
            } else if (select == 4) {
                System.out.println("=====Find by id menu=====");
                System.out.print("Введите номер id заявки, которую вы хотите найти");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Заявки с таким id не существует.");
                } else {
                    System.out.println("Заявка с требуемым id: " + item);
                }
            } else if (select == 5) {
                System.out.println("=====Find by name menu=====");
                System.out.print("Введите имя заявки, которое вы хотите найти");
                String name = scanner.nextLine();
                Item[] names = tracker.findByName(name);
                if (names.length == 0) {
                    System.out.println("В массиве нет заявок с искомым именем");
                } else {
                    for (Item item : names) {
                        System.out.println("Искомая заявка - " + item);
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
