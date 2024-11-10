package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftFirst = left.split("/", 2);
        String[] rightFirst = right.split("/", 2);
        if (rightFirst[0].compareTo(leftFirst[0]) != 0) {
            int result = rightFirst[0].compareTo(leftFirst[0]);
            return result != 0 ? result : left.compareTo(right);
        }
        if (leftFirst.length > 1 && rightFirst.length > 1) {
            return leftFirst[1].compareTo(rightFirst[1]);
        }
        return Integer.compare(leftFirst.length, rightFirst.length);
    }
}
