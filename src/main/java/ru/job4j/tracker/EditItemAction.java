package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=====Edit item menu=====");
        int id = input.askInt("Enter id for edit: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            out.println("Имя заявки с id " + id + " успешно изменено на " + name + ".");
        } else {
            out.println("Заявки с таким id не существует.");
        }
        return true;
    }
}
