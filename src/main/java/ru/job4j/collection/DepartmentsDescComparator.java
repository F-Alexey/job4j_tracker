package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] dept1 = left.split("/");
        String[] dept2 = right.split("/");
        int result = dept2[0].compareTo(dept1[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}