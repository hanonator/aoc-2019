package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

import java.util.function.BiFunction;

public class OperationInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 3;

    public final BiFunction<Long, Long, Long> operation;

    public OperationInstruction(BiFunction<Long, Long, Long> operation) {
        super(PARAMETER_COUNT);
        this.operation = operation;
    }

    @Override
    public void execute(Memory memory, Parameter[] params) {
        long paramA = memory.read(params[0]);
        long paramB = memory.read(params[1]);

        memory.write(operation.apply(paramA, paramB), params[2]);
    }

}
