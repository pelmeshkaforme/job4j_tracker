package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=====Delete item menu=====");
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id " + id + " успешно удалена.");
        } else {
            System.out.println("Заявки с таким id не существует.");
        }
        return true;
    }
}
