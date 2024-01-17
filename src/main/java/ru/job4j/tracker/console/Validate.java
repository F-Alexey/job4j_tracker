package ru.job4j.tracker.console;

public class Validate extends Input {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}
