package com.dopscape.intcode.processor;

import com.dopscape.intcode.Memory;

public class Parameter {

    private final ParameterMode mode;
    private final long value;

    public Parameter(ParameterMode mode, long value) {
        this.mode = mode;
        this.value = value;
    }

    public ParameterMode getMode() {
        return this.mode;
    }

    public long getValue() {
        return this.value;
    }

}
