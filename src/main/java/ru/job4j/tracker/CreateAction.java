package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=====Add item menu=====");
        String name = input.askStr("Fill Item name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавления заявка: " + item);
        return true;
    }
}
