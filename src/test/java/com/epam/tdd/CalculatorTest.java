package com.epam.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

    private static Calculator calculator;
    private static Map<Integer, Long> expectedValuesSource = prepareMap();

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void factorialTest(int n) {
        long actual = calculator.factorial(n);
        long expected = expectedValuesSource.get(n);
        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    void multiplyTest() {
        int actual = calculator.multiply(1, 2, 3);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void divideTest() {
        Throwable thrown = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals(ArithmeticException.class, thrown.getClass());
    }

    private static Map<Integer, Long> prepareMap() {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        map.put(1, 1L);
        map.put(2, 2L);
        map.put(3, 6L);
        map.put(4, 24L);
        map.put(5, 120L);
        return map;
    }
}