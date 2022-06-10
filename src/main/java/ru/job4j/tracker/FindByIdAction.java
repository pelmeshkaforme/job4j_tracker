package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=====Find by id menu=====");
        int id = input.askInt("Enter id for search: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявки с таким id не существует.");
        } else {
            System.out.println("Заявка с требуемым id: " + item);
        }
        return true;
    }
}
