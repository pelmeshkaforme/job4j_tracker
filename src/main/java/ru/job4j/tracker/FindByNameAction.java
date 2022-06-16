package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Find by name menu=====");
        String name = input.askStr("Enter name for search: ");
        Item[] names = tracker.findByName(name);
        if (names.length == 0) {
            out.println("Заявки с таким name не существует.");
        } else {
            for (Item item : names) {
                out.println("Заявка с требуемым name: " + item);
            }
        }
        return true;
    }
}
