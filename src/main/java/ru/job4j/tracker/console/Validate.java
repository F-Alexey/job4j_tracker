package ru.job4j.tracker.console;

import ru.job4j.tracker.input.Input;

public class Validate implements Input {
    private final ru.job4j.tracker.output.Output output;
    private final ru.job4j.tracker.input.Input input;

    public Validate(ru.job4j.tracker.output.Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}
