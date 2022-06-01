package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=====Add item menu=====");
        String name = input.askStr("Fill Item name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавления заявка: " + item);
    }

    public static void findAllItem(Input input, Tracker tracker) {
        System.out.println("=====Show all items menu=====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Пока еще нет ни одной заявки.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=====Edit item menu=====");
        int id = input.askInt("Enter id for edit: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Имя заявки с id " + id + " успешно изменено на " + name + ".");
        } else {
            System.out.println("Заявки с таким id не существует.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=====Delete item menu=====");
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id " + id + " успешно удалена.");
        } else {
            System.out.println("Заявки с таким id не существует.");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=====Find by id menu=====");
        int id = input.askInt("Enter id for search: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявки с таким id не существует.");
        } else {
            System.out.println("Заявка с требуемым id: " + item);
        }
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("=====Find by name menu=====");
        String name = input.askStr("Enter name for search: ");
        Item[] names = tracker.findByName(name);
        if (names.length == 0) {
            System.out.println("Заявки с таким name не существует.");
        } else {
            for (Item item : names) {
                System.out.println("Заявка с требуемым name: " + item);
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Введите номер пункта меню: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all Items", "Edit Item", "Delete Item", "Find Item by id",
                "Find Item by name", "Exit Program"
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
