package com.devcalc.CalculatorService;

import com.devcalc.CalculatorService.Operations.IOperation;

public class CalculatorService {
    
    public static <T1, T2, outT> outT Calculate(T1 a, T2 b, IOperation<T1, T2, outT> operation) {
        return operation.apply(a, b);
    }
}