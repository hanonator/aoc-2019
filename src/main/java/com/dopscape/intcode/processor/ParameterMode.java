package com.dopscape.intcode.processor;

import com.dopscape.intcode.Memory;

import java.util.function.BiFunction;

public enum ParameterMode {

    POSITION((memory, value) -> memory.peek(value.intValue())),
    IMMEDIATE((memory, value) -> value),
    RELATIVE((memory, value) -> memory.peek(memory.getRelativeBase() + value.intValue()));

    private final BiFunction<Memory, Long, Long> function;

    ParameterMode(BiFunction<Memory, Long, Long> function) {
        this.function = function;
    }

    public long extract(Memory memory, long value) {
        return this.function.apply(memory, value);
    }

}
