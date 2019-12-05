package com.dopscape.processor;

import com.dopscape.memory.Memory;

import java.util.function.BiFunction;

public enum Mode {

    /**
     * The input is the address of where the value is stored
     */
    POSITION((input, memory) -> memory.get(input)),

    /**
     * The input is the value
     */
    IMMEDIATE(((input, memory) -> input));

    private final BiFunction<Integer, Memory, Integer> function;

    Mode(BiFunction<Integer, Memory, Integer> function) {
        this.function = function;
    }

    public int apply(int input, Memory memory) {
        return function.apply(input, memory);
    }

}
