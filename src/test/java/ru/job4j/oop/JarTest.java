package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class JarTest {

    @Test
    public void whenFirst10AndSecond40() {
        Jar first = new Jar(10);
        Jar second = new Jar(40);
        first.calculate(second);
        assertEquals(50, first.getValue());
        assertEquals(0, second.getValue());
    }

    @Test
    public void whenSecondIs0() {
        Jar first = new Jar(20);
        Jar second = new Jar(0);
        first.calculate(second);
        assertEquals(20, first.getValue());
        assertEquals(0, second.getValue());
    }

    @Test
    public void whenFirst20Second0() {
        Jar first = new Jar(20);
        Jar second = new Jar(0);
        second.calculate(first);
        assertEquals(0, first.getValue());
        assertEquals(20, second.getValue());
    }
}