package ru.job4j.tracker;

public class FindAllItemAction implements UserAction {
    private final Output out;

    public FindAllItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Show all items menu=====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            out.println("Пока еще нет ни одной заявки.");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}
