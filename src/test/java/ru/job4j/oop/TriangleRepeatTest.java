package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleRepeatTest {

    @Test
    public void when00and05and50Then12dot5() {
        PointRepeat first = new PointRepeat(0, 0);
        PointRepeat second = new PointRepeat(0, 5);
        PointRepeat third  = new PointRepeat(5, 0);
        TriangleRepeat triangle = new TriangleRepeat(first, second, third);
        assertEquals(12.5, triangle.area(), 0.1);
    }
}