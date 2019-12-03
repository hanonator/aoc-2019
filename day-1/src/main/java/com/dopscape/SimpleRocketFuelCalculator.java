package com.dopscape;

import java.util.Set;

public class SimpleRocketFuelCalculator implements RocketFuelCalculator {

    @Override
    public int calculateTotal(int mass) {
        return this.calculateSingle(mass);
    }

}
