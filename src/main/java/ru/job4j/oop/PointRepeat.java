package ru.job4j.oop;

import static java.lang.Math.*;

public class PointRepeat {
    private int x;
    private int y;

    public PointRepeat(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(PointRepeat to) {
        return sqrt(pow(to.x - this.x, 2) + pow(to.y - this.y, 2));
    }

    public static void main(String[] args) {
        PointRepeat from = new PointRepeat(0, 0);
        PointRepeat to = new PointRepeat(0, 10);
        System.out.println(from.distance(to));

    }

}
