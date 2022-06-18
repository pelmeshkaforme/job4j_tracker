package ru.job4j.ex;

public class Count {
    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start must be less than finish");
        }
        int count = 0;
        for (int i = start; i <= finish; i++) {
            count = count + i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Sum from start to finish is " + add(9, 5));
    }
}
