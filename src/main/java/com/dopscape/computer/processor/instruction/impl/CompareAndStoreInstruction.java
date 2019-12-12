package com.dopscape.computer.processor.instruction.impl;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.Parameter;
import com.dopscape.computer.processor.instruction.Instruction;

import java.util.function.BiPredicate;

public class CompareAndStoreInstruction implements Instruction {

    private final BiPredicate<Integer, Integer> predicate;

    public CompareAndStoreInstruction(BiPredicate<Integer, Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        boolean flag = predicate.test(parameters[0].getAdjustedValue(memory), parameters[1].getAdjustedValue(memory));
        memory.store(flag ? 1 : 0, parameters[2].getValue());
    }

    @Override
    public int getParameterCount() {
        return 3;
    }

}
