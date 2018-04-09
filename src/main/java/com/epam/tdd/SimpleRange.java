package com.epam.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleRange implements Range {

    private long lowerBound;
    private long upperBound;


    @Override
    public boolean isBefore(Range otherRange) {
        if (otherRange == null) {
            return false;
        }
        return upperBound < otherRange.getLowerBound();
    }

    @Override
    public boolean isAfter(Range otherRange) {
        if (otherRange == null) {
            return false;
        }
        return lowerBound > otherRange.getUpperBound();
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return false;
    }

    @Override
    public long getLowerBound() {
        return lowerBound;
    }

    @Override
    public long getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean contains(long value) {
        return lowerBound <= value && value <= upperBound;
    }

    @Override
    public List<Long> asList() {
        return new ArrayList<>();
    }

    @Override
    public Iterator<Long> asIterator() {
        return null;
    }
}
