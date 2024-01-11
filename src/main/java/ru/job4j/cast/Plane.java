package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Двигается по взлетно-посадочной полосе.");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " Включает двигатели обратной тяги и останавливается.");
    }
}
