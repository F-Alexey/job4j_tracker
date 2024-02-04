package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;
import ru.job4j.tracker.console.Validate;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final ru.job4j.tracker.output.Output output;

    public StartUI(ru.job4j.tracker.output.Output output) {
        this.output = output;
    }

    public void init(ru.job4j.tracker.input.Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        int index = 0;
        for (UserAction element : actions) {
            output.println(index + ". " + element.name());
            index++;
        }

    }

    public static void main(String[] args) {
        ru.job4j.tracker.output.Output output = new Output();
        ru.job4j.tracker.input.Input input = new Validate(output, new Input());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new FindAll(output));
        actions.add(new Replace(output));
        actions.add(new Delete(output));
        actions.add(new FindById(output));
        actions.add(new FindByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}