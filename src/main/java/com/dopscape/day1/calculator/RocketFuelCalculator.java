package com.dopscape.day1.calculator;

import java.util.Set;

public interface RocketFuelCalculator {

    int calculateTotal(int input);

    default int calculateSingle(int input) {
        return input / 3 - 2;
    }

    default int aggregate(Set<Integer> input) {
        return input.stream().mapToInt(this::calculateTotal).sum();
    }

}
