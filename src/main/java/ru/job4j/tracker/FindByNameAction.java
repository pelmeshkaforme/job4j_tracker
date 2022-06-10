package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
