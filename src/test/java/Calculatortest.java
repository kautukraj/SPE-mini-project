import calculator.Calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Calculatortest
{
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void multiplicationTruePositive()
    {
        assertEquals("Finding multiplication of two number for True Positive", 21, calculator.multiplication(7, 3), DELTA);
        assertEquals("Finding multiplication of two number for True Positive", 30, calculator.multiplication(6, 5), DELTA);
    }

    @Test
    public void multiplicationFalsePositive()
    {
        assertNotEquals("Finding multiplication of two number for False Positive", 120, calculator.multiplication(5, 7), DELTA);
        assertNotEquals("Finding multiplication of two number for False Positive", 80, calculator.multiplication(4, 11), DELTA);
    }

    @Test
    public void squareTruePositive()
    {
        assertEquals("Finding sqaure for True Positive", 25, calculator.square(5), DELTA);
        assertEquals("Finding sqaure for True Positive", 1, calculator.square(1), DELTA);
    }

    @Test
    public void squareFalsePositive()
    {
        assertNotEquals("Finding square for False Positive", 140, calculator.square(3), DELTA);
        assertNotEquals("Finding square for False Positive", 203, calculator.square(4), DELTA);

    }

    @Test
    public void cuberootTruePositive()
    {
        assertEquals("Finding cuberoot for True Positive", 9, calculator.cuberoot(729), DELTA);
        assertEquals("Finding cuberoot for True Positive", -5, calculator.cuberoot(-125), DELTA);
    }

    @Test
    public void cuberootFalsePositive()
    {
        assertNotEquals("Finding cuberoot for False Positive", 111, calculator.cuberoot(121), DELTA);
        assertNotEquals("Finding cuberoot for False Positive", 32, calculator.cuberoot(8), DELTA);

    }


    @Test
    public void subTruePositive()
    {
        assertEquals("Finding subtraction of two number for True Positive", 7, calculator.sub(10, 3), DELTA);
        assertEquals("Finding subtraction of two number for True Positive", -5, calculator.sub(6, 11), DELTA);
    }

    @Test
    public void subFalsePositive()
    {
        assertNotEquals("Finding subtraction of two number for False Positive", 4, calculator.sub(5, 8), DELTA);
        assertNotEquals("Finding subtraction of two number for False Positive", -10, calculator.sub(5, 4), DELTA);
    }


}
