package ru.job4j.collection.job;

import java.util.Comparator;

public class AscByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
