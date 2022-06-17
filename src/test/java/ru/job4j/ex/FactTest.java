package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test
    public void when3Then6() {
        int rsl = Fact.fact(3);
        assertEquals(rsl, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberIsLessThanZero() {
        Fact.fact(-3);
    }
}