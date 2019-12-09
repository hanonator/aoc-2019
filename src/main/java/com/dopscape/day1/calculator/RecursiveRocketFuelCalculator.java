package com.dopscape.day1.calculator;

public class RecursiveRocketFuelCalculator implements RocketFuelCalculator {

    @Override
    public int calculateTotal(int input) {
        return test(calculateSingle(input));
    }

    private int test(int total) {
        if (total <= 0) {
            return 0;
        }
        return total + test(calculateSingle(total));
    }

}
