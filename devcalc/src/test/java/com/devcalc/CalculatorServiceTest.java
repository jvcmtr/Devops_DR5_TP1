package com.devcalc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.devcalc.CalculatorService.CalculatorService;
import com.devcalc.CalculatorService.Operations.IntegerOperations;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;


public class CalculatorServiceTest {
    @Property
    void testIntegerAddition(@ForAll("integers") int a, @ForAll("integers") int b) {
        Integer result = CalculatorService.Calculate(a, b, IntegerOperations.ADD);
        Integer expected = a+b;
        assertEquals(result, expected);
    }
    @Property
    void testIntegerSubtraction(@ForAll("integers") int a, @ForAll("integers") int b) {
        Integer result = CalculatorService.Calculate(a, b, IntegerOperations.SUBTRACT);
        Integer expected = a-b;
        assertEquals(result, expected);
    }
    @Property
    void testIntegerMultiplication(@ForAll("integers") int a, @ForAll("integers") int b) {
        Integer result = CalculatorService.Calculate(a, b, IntegerOperations.MULTIPLY);
        Integer expected = a*b;
        assertEquals(result, expected);
    }
    @Property
    void testIntegerDivision(@ForAll("integers") int a, @ForAll("integers") int b) {
        if(b == 0){
             assertThrows( ArithmeticException.class, ()-> CalculatorService.Calculate(a, b, IntegerOperations.DIVIDE) );
        }
        else {
            Integer result = CalculatorService.Calculate(a, b, IntegerOperations.DIVIDE);
            Integer expected = a/b;
            assertEquals(result, expected);
        }
    }

    @Provide
    Arbitrary<Integer> integers() {
        return Arbitraries.integers().between(-1_000, 1_000);
    }
}
