package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void whenPoint00and04and30Then6() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        Point c = new Point(3, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 6;
        assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void whenPoint00and55and05Then12dot5() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 5);
        Point c = new Point(0, 5);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 12.5;
        assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void whenPoint00and55and6ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(0, 6);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        assertEquals(rsl, expected, 0.01);
    }
}