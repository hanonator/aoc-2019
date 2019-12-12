package com.dopscape.computer.processor.instruction.impl;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.Parameter;
import com.dopscape.computer.processor.instruction.Instruction;

import java.util.function.Predicate;

public class ConditionalJumpInstruction implements Instruction {

    private final Predicate<Integer> predicate;

    public ConditionalJumpInstruction(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        if (predicate.test(parameters[0].getAdjustedValue(memory))) {
            memory.position(parameters[1].getAdjustedValue(memory));
        }
    }

    @Override
    public int getParameterCount() {
        return 2;
    }

}
