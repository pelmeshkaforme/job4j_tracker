package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Delete item menu=====");
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            out.println("Заявка с id " + id + " успешно удалена.");
        } else {
            out.println("Заявки с таким id не существует.");
        }
        return true;
    }
}
