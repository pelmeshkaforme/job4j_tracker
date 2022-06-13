package ru.job4j.oop;

import static java.lang.Math.*;

public class TriangleRepeat {
    private PointRepeat first;
    private PointRepeat second;
    private PointRepeat third;

    public TriangleRepeat(PointRepeat ap, PointRepeat bp, PointRepeat cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(Double ab, Double ac, Double bc) {
        return (ab + ac + bc) / 2;
    }

    public boolean exist(Double ab, Double ac, Double bc) {
        return ab + ac > bc && ac + bc > ab && ab + bc > ac;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    public static void main(String[] args) {
        PointRepeat first = new PointRepeat(0, 0);
        PointRepeat second = new PointRepeat(5, 5);
        PointRepeat third = new PointRepeat(0, 5);
        TriangleRepeat triangle = new TriangleRepeat(first, second, third);
        double rsl = triangle.area();
        if (rsl == -1) {
            System.out.println("Треугольник не существует");
        } else {
            System.out.println(rsl);
        }
    }
}
