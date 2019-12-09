package com.dopscape.day1.calculator;

public class SimpleRocketFuelCalculator implements RocketFuelCalculator {

    @Override
    public int calculateTotal(int mass) {
        return this.calculateSingle(mass);
    }

}
