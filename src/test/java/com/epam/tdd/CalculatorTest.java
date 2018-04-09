package com.epam.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 6", "4, 24", "5, 120"})
    void factorialTest(int actual, long expected) {
        assertThat(calculator.factorial(actual), is(equalTo(expected)));
    }

    @Disabled
    @Test
    void multiplyTest() {
        int actual = calculator.multiply(1, 2, 3);
        int expected = 6;
        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    @DisplayName("throws ArithmeticException")
    void divideTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}