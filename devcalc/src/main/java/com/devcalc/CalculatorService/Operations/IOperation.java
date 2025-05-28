package com.devcalc.CalculatorService.Operations;

public interface IOperation<T1, T2, outT> {
    outT apply(T1 a, T2 b);
}