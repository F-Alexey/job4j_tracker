package ru.job4j.polymorphism;

public interface Transport {
    void go();

    void passenger(Integer count);

    int refill(Integer litres);

}
