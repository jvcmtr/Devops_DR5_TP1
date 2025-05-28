package com.devcalc.CalculatorService.Operations;

import java.util.EnumMap;
import java.util.Map;


interface IntegerOperation extends  IOperation<Integer, Integer, Integer> {
    Integer apply(Integer a, Integer b);
}

public class IntegerOperations {
    public static final IntegerOperation ADD = (a, b) -> a+b;
    public static final IntegerOperation SUBTRACT = (a, b) -> a-b;
    public static final IntegerOperation MULTIPLY = (a, b) -> a*b;
    public static final IntegerOperation DIVIDE = (a, b) -> {
        if (b == 0) { throw new ArithmeticException("Division by zero!"); }
        return a / b;
    };
}
