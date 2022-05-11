package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int c) {
        return c - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int e, int sum, int multiply, int minus, int divide) {
        return e + sum + multiply + minus + divide;
    }

    public static void main(String[] args) {
        int rslSum = sum(1);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(3);
        System.out.println(rslMultiply);
        int rslMinus = minus(8);
        System.out.println(rslMinus);
        Calculator calcDivide = new Calculator();
        int rslDivide = calcDivide.divide(40);
        System.out.println(calcDivide.divide(40));
        Calculator sumAll = new Calculator();
        System.out.println(sumAll.sumAllOperation(9, rslSum, rslMultiply, rslMinus, rslDivide));
    }
}
