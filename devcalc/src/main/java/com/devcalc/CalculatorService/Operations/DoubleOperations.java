package com.devcalc.CalculatorService.Operations;

interface DoubleOperation extends IOperation<Double, Double, Double> {
    Double apply(Double a, Double b);
}

public class DoubleOperations {
    public static final DoubleOperation ADD = (a, b) -> a+b;
    public static final DoubleOperation SUBTRACT = (a, b) -> a-b;
    public static final DoubleOperation MULTIPLY = (a, b) -> a*b;
    public static final DoubleOperation DIVIDE = (a, b) -> {
        if (b == 0) { throw new ArithmeticException("Division by zero!"); }
        return a / b;
    };
}