package ru.job4j.tracker.console;

public class Output implements ru.job4j.tracker.output.Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}
