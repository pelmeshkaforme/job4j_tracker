package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreterThanFinish() {
        Count.add(10, 2);
    }

    @Test
    public void when0to2Then3() {
        int rsl = Count.add(0, 2);
        assertEquals(rsl, 3);
    }
}