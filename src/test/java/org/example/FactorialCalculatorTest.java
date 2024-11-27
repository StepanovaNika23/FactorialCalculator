package org.example;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialCalculatorTest{
    private final FactorialCalculator calculator = new FactorialCalculator();
    @Test
    public void testFactorialZero() {
        Assert.assertEquals(1, calculator.calculateFactorial(0));
    }

    @Test
    public void testFactorialOne() {
        Assert.assertEquals(1, calculator.calculateFactorial(1));
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(120, calculator.calculateFactorial(5));
    }
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {6, 720},
                {10, 3628800}
        };
        };

    @Test(dataProvider = "factorialData")
    public void testFactorialParameterized(int n, long expected) {
        Assert.assertEquals(expected, calculator.calculateFactorial(n));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        calculator.calculateFactorial(-1);
    }

}
