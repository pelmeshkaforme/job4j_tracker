package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=====Add item menu=====");
        String name = input.askStr("Fill item name");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавления заявка - " + item);
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=====Edit item menu=====");
        int id = input.askInt("Введите id заявки, которую вы хотите изменить");
        String name = input.askStr("Введите новое имя заявки, которую вы хотите изменить");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Имя заявки с id " + id + " успешно изменено на " + name);
        } else {
            System.out.println("Заявки с введенным ид не существует");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=====Delete item menu=====");
        int id = input.askInt("Введите номер id, которое требуется удалить");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id " + id + " успешно удалена.");
        } else {
            System.out.println("Заявки с таким id не существует.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Введите номер пункта меню");
            if (select == 0) {
                StartUI.createItem(input, tracker);
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
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                System.out.println("=====Find by id menu=====");
                int id = input.askInt("Введите номер id заявки, которую вы хотите найти");
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Заявки с таким id не существует.");
                } else {
                    System.out.println("Заявка с требуемым id: " + item);
                }
            } else if (select == 5) {
                System.out.println("=====Find by name menu=====");
                String name = input.askStr("Введите имя заявки, которое вы хотите найти");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
