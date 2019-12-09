package com.dopscape.day2.processor.instruction;

import com.dopscape.day2.memory.Memory;
import com.dopscape.day2.processor.Parameter;

import java.util.function.Consumer;

public class WriteInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 1;

    private final Consumer<Integer> out;

    public WriteInstruction(Consumer<Integer> out) {
        this.out = out;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        out.accept(parameters[0].getAdjustedValue(memory));
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
