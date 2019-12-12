package com.dopscape.computer.processor.instruction.impl;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.Parameter;
import com.dopscape.computer.processor.instruction.Instruction;

import java.util.function.Supplier;

public class ReadInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 1;

    private final Supplier<Integer> in;

    public ReadInstruction(Supplier<Integer> in) {
        this.in = in;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        memory.store(in.get(), parameters[0].getValue());
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
