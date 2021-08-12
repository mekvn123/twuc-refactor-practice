package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class NumberCruncher {
    public static final int EVEN = 0;
    public static final int ODD = 1;
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return getCount(EVEN);
    }

    public int countOdd() {
        return getCount(ODD);
    }

    private int getCount(int oddOrEven) {
        return (int) Arrays.stream(numbers).filter(value -> value % 2 == oddOrEven).count();
    }


    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(value -> value >= 0).count();
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers).filter(value -> value < 0).count();

    }
}
