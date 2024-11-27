package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();
    @Test
    void testFactorialZero() {
        Assertions.assertEquals(1, calculator.calculateFactorial(0));
    }
    @Test
    void testFactorialOne() {
        Assertions.assertEquals(1, calculator.calculateFactorial(1));
    }

    @Test
    void testFactorialPositive() {
        Assertions.assertEquals(120, calculator.calculateFactorial(5));
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "5,120", "6,720"})
    void testFactorialParameterized(int n, long expected) {
        Assertions.assertEquals(expected, calculator.calculateFactorial(n));
    }

    @Test
    void testFactorialNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }

}
