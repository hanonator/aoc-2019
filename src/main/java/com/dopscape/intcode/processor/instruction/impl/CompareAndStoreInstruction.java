package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

import java.util.function.BiPredicate;

public class CompareAndStoreInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 3;
    private final BiPredicate<Long, Long> predicate;

    public CompareAndStoreInstruction(BiPredicate<Long, Long> predicate) {
        super(PARAMETER_COUNT);
        this.predicate = predicate;
    }

    @Override
    public void execute(Memory memory, Parameter[] params) {
        boolean flag = predicate.test(memory.read(params[0]), memory.read(params[1]));
        memory.write(flag ? 1 : 0, params[2]);
    }
}
