package ru.job4j.tracker.console;

import java.util.Scanner;

public class Input implements ru.job4j.tracker.input.Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
