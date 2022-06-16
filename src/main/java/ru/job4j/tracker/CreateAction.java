package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Add item menu=====");
        String name = input.askStr("Fill Item name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавления заявка: " + item);
        return true;
    }
}
