package com.dopscape;

import com.dopscape.memory.ArrayMemory;
import com.dopscape.memory.Memory;
import com.dopscape.processor.operation.Operation;

import java.util.Arrays;

public class IntcodeComputer {

    private final Memory memory;

    public IntcodeComputer(int[] input) {
        this.memory = new ArrayMemory(Arrays.copyOf(input, input.length));
    }

    public IntcodeComputer execute(Operation operation) {
        operation.process(memory);
        return this;
    }

    public IntcodeComputer prepare() {
        memory.put(12, 1);
        memory.put(2, 2);
        return this;
    }

    public Memory getMemory() {
        return this.memory;
    }

}
