package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Поехали");
    }

    @Override
    public void passenger(Integer count) {
        System.out.println("Количество пассажиров = " + count);
    }

    @Override
    public int refill(Integer litres) {
        return litres * 50;
    }

}
