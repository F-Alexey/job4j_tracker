package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.console.Output;
import ru.job4j.tracker.console.Validate;

public class StartUI {
    private final ru.job4j.tracker.output.Output output;

    public StartUI(ru.job4j.tracker.output.Output output) {
        this.output = output;
    }

    public void init(ru.job4j.tracker.input.Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.length) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        ru.job4j.tracker.output.Output output = new Output();
        ru.job4j.tracker.input.Input input = new Validate();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}