package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    private static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumOfAllOperation(int sum, int minus, int multiply, int divide) {
        return sum + minus + multiply + divide;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        int result2 = Calculator.minus(15);
        System.out.println(result2);
        int result1 = calculator.multiply(5);
        System.out.println(result1);
        int result3 = calculator.divide(20);
        System.out.println(result3);
        int result4 = calculator.sumOfAllOperation(result, result2, result1, result3);
        System.out.println(result4);
    }
}