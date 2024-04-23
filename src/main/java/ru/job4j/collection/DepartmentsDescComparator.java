package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] dept1 = left.split("/");
        String[] dept2 = right.split("/");

        int result = dept2[0].compareTo(dept1[0]);

        if (result == 0) {
            int minStringLength = Math.min(dept1.length, dept2.length);
            for (int i = 1; i < minStringLength; i++) {
                int comparison = dept1[i].compareTo(dept2[i]);
                if (comparison != 0) {
                    return comparison;
                }
            }
            return Integer.compare(dept1.length, dept2.length);
        }

        return result;
    }
}