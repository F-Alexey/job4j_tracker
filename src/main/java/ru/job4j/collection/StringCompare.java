package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        int minStringLength = Math.min(leftLength, rightLength);
        for (int i = 0; i < minStringLength; i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(leftLength, rightLength);
        }
        return result;
    }
}
