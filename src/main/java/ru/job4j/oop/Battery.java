package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(50);
        Battery second = new Battery(10);
        System.out.println("Load of first is " + first.load + " load of second is " + second.load);
        first.exchange(second);
        System.out.println("Load of first is " + first.load + " load of second is " + second.load);
    }
}
