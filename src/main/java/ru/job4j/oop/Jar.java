package ru.job4j.oop;

public class Jar {

    private int value;

    public Jar(int size) {
        this.value = size;
    }

    public void calculate(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Jar first = new Jar(100);
        Jar second = new Jar(30);
        System.out.println("Состояние до: первый сосуд - " + first.value + ", второй сосуд - " + second.value);
        first.calculate(second);
        System.out.println("Состояние после: первый сосуд - " + first.value + ", второй сосуд - " + second.value);
        second.calculate(first);
        System.out.println("Состояние после: первый сосуд - " + first.value + ", второй сосуд - " + second.value);

    }
}
