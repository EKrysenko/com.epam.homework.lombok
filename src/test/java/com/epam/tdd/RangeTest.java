package com.epam.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RangeTest {

    private static  Range range;

    @BeforeAll
    static void init() {
        range = new SimpleRange(10, 20);
    }

    @ParameterizedTest
    @CsvSource({"true, 25, 30", "true, 30, 40", "false, 0, 15"})
    void isBeforeTest(boolean expected, long lowerBound, long upperBound) {
        Range otherRange = new SimpleRange(lowerBound, upperBound);
        assertThat(expected, is(equalTo(range.isBefore(otherRange))));
    }

    @ParameterizedTest
    @CsvSource({"false, 25, 30", "false, 30, 40", "true, 0, 9"})
    void isAfterTest(boolean expected, long lowerBound, long upperBound) {
        Range otherRange = new SimpleRange(lowerBound, upperBound);
        assertThat(expected, is(equalTo(range.isAfter(otherRange))));
    }

    @Test
    void isConcurrentTest() {
    }

    @Test
    void containsTest() {
    }

    @Test
    void asListTest() {
    }

    @Test
    void asIteratorTest() {
    }
}