package com.dopscape.computer.processor.instruction;

import com.dopscape.computer.memory.Memory;

public class Parameter {

    private final int value;
    private final Mode mode;

    public Parameter(int value, Mode mode) {
        this.value = value;
        this.mode = mode;
    }

    public int getValue() {
        return value;
    }

    public Mode getMode() {
        return mode;
    }

    public int getAdjustedValue(Memory memory) {
        return mode.apply(value, memory);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "value=" + value +
                ", mode=" + mode +
                '}';
    }
}
