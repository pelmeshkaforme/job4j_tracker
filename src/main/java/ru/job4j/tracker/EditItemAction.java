package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=====Edit item menu=====");
        int id = input.askInt("Enter id for edit: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Имя заявки с id " + id + " успешно изменено на " + name + ".");
        } else {
            System.out.println("Заявки с таким id не существует.");
        }
        return true;
    }
}
