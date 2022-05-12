package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when0and0To4and3Then5() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 3);
        double rsl = a.distance(b);
        double expected = 5;
        assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when0and0and0To5and5and5Then7dot16() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(5, 5, 5);
        double rsl = a.distance3D(b);
        double expected = 8.66;
        assertEquals(expected, rsl, 0.01);
    }
}