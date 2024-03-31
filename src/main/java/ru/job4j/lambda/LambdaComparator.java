package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaComparator {
    public static void main(String[] args) {
        Comparator<String> comparatorText = (left, right) -> right.compareTo(left);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(left.length(), right.length());
        String left = ("efghijk");
        String right = ("abcd");
        System.out.println(comparatorText.compare(left, right) > 0 ? left + "; " + right + " sort by alphabet" : right + "; " + left + " sort by alphabet");
        System.out.println(comparatorDescSize.compare(left, right) > 0 ? left + "; " + right + " sort by descSize" : right + "; " + left + " sort by descSize");
    }
}
