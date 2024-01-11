package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Едет по рельсам.");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " Останавливается через 150 метров.");
    }
}
