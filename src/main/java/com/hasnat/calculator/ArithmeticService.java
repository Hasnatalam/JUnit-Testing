package com.hasnat.calculator;

public class ArithmeticService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed");
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        if (b == 0) throw new ArithmeticException("Modulus by zero not allowed");
        return a % b;
    }
}
