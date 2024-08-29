package com.example.stringcalculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    //Test for Empty String, Single and Two numbers
    @Test
    public void testEmptyString() {

        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }


    @Test
    public void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,5");
        assertEquals(6,result);
    }

    //Test for the Newline as delimiter
    @Test
    public void testNewLineDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        assertEquals(6,result);
    }

    // Test for the custom delimiter
    @Test
    public void testCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    //Test for Negative Numbers
    @Test
    public void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-3");
        });
        assertEquals("Negative numbers not allowed: -2,-3", exception.getMessage());
    }
}
