package ru.job4j.tracker;

import org.junit.Test;

import javax.swing.text.TabableView;
import java.rmi.StubNotFoundException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        int index = item.getId();
        String replacedName = "New Item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(index), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        int index = item.getId();
        Input in = new StubInput(
                new String[] {"0", Integer.toString(index), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "New Item name", "1"}
        );
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Add new Item" + ln
                + "1.Exit" + ln
                + "=====Add item menu=====" + ln
                + "Добавлена заявка: " + tracker.findAll()[0] + ln
                + "Menu:" + ln
                + "0.Add new Item" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindAllTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item name"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Find all Item" + ln
                + "1.Exit" + ln
                + "=====Show all items menu=====" + ln
                + tracker.findAll()[0] + ln
                + "Menu:" + ln
                + "0.Find all Item" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Find all Item" + ln
                + "1.Exit" + ln
                + "=====Show all items menu=====" + ln
                + "Пока еще нет ни одной заявки." + ln
                + "Menu:" + ln
                + "0.Find all Item" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item name"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "New Item name", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Edit Item" + ln
                + "1.Exit" + ln
                + "=====Edit item menu=====" + ln
                + "Имя заявки с id " + item.getId() + " успешно изменено на " + "New Item name" + "." + ln
                + "Menu:" + ln
                + "0.Edit Item" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenEditItemTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1", "New Item name", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0.Edit Item" + ln
                        + "1.Exit" + ln
                        + "=====Edit item menu=====" + ln
                        + "Заявки с таким id не существует." + ln
                        + "Menu:" + ln
                        + "0.Edit Item" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenDeleteItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete Item name"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Delete Item" + ln
                + "1.Exit" + ln
                + "=====Delete item menu=====" + ln
                + "Заявка с id " + item.getId() + " успешно удалена." + ln
                + "Menu:" + ln
                + "0.Delete Item" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenDeleteItemTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0.Delete Item" + ln
                        + "1.Exit" + ln
                        + "=====Delete item menu=====" + ln
                        + "Заявки с таким id не существует." + ln
                        + "Menu:" + ln
                        + "0.Delete Item" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item name"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Find by id" + ln
                + "1.Exit" + ln
                + "=====Find by id menu=====" + ln
                + "Заявка с требуемым id: " + item + ln
                + "Menu:" + ln
                + "0.Find by id" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0.Find by id" + ln
                        + "1.Exit" + ln
                        + "=====Find by id menu=====" + ln
                        + "Заявки с таким id не существует." + ln
                        + "Menu:" + ln
                        + "0.Find by id" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Masha"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0.Find by name" + ln
                        + "1.Exit" + ln
                        + "=====Find by name menu=====" + ln
                        + "Заявка с требуемым name: " + item + ln
                        + "Menu:" + ln
                        + "0.Find by name" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Masha", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0.Find by name" + ln
                        + "1.Exit" + ln
                        + "=====Find by name menu=====" + ln
                        + "Заявки с таким name не существует." + ln
                        + "Menu:" + ln
                        + "0.Find by name" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenInvalidEnterMenuNumber() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"3", "0", "New item name", "1"}
        );
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Add new Item" + ln
                + "1.Exit" + ln
                + "Wrong input, you can select: from 0 to " + (actions.length - 1) + ln
                + "Menu:" + ln
                + "0.Add new Item" + ln
                + "1.Exit" + ln
                + "=====Add item menu=====" + ln
                + "Добавлена заявка: " + tracker.findAll()[0] + ln
                + "Menu:" + ln
                + "0.Add new Item" + ln
                + "1.Exit" + ln
        ));
    }
}