package ru.job4j.pojo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 5);
        products[2] = new Product("Egg", 47);
        int rsl = Shop.indexOfNull(products);
        int expected = 3;
        assertEquals(rsl, expected);
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[2] = new Product("Milk", 10);
        products[3] = new Product("Bread", 5);
        products[4] = new Product("Egg", 47);
        int rsl = Shop.indexOfNull(products);
        int expected = 0;
        assertEquals(rsl, expected);
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 5);
        products[2] = new Product("Egg", 47);
        int rsl = Shop.indexOfNull(products);
        int expected = -1;
        assertEquals(rsl, expected);
    }
}