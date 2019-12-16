package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

import java.util.function.Predicate;

public class ConditionalJumpInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 2;

    private final Predicate<Long> predicate;

    public ConditionalJumpInstruction(Predicate<Long> predicate) {
        super(PARAMETER_COUNT);
        this.predicate = predicate;
    }

    @Override
    public void execute(Memory memory, Parameter[] params) {
        if (predicate.test(memory.read(params[0]))) {
            memory.pointer((int) memory.read(params[1]));
        }
    }

}
