package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    private static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumOfAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sumResult = Calculator.sum(10);
        System.out.println(sumResult);
        int minusResult = Calculator.minus(10);
        System.out.println(minusResult);
        int multiplyResult = calculator.multiply(10);
        System.out.println(multiplyResult);
        int divideResult = calculator.divide(10);
        System.out.println(divideResult);
        int sumOfAllOperationResult = calculator.sumOfAllOperation(10);
        System.out.println(sumOfAllOperationResult);
    }
}