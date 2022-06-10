package ru.job4j.tracker;

public class FindAllItemAction implements UserAction {
    @Override
    public String name() {
        return "Find all Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=====Show all items menu=====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Пока еще нет ни одной заявки.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        return true;
    }
}
