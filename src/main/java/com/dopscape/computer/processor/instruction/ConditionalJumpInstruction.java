package com.dopscape.day2.processor.instruction;

import com.dopscape.day2.memory.Memory;
import com.dopscape.day2.processor.Parameter;

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
