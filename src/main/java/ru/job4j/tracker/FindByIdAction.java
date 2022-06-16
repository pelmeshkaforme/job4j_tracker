package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Find by id menu=====");
        int id = input.askInt("Enter id for search: ");
        Item item = tracker.findById(id);
        if (item == null) {
            out.println("Заявки с таким id не существует.");
        } else {
            out.println("Заявка с требуемым id: " + item);
        }
        return true;
    }
}
