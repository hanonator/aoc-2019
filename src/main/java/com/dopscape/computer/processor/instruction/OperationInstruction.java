package com.dopscape.day2.processor.instruction;

import com.dopscape.day2.memory.Memory;
import com.dopscape.day2.processor.Parameter;

import java.util.function.BiFunction;

public class OperationInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 3;

    public final BiFunction<Integer, Integer, Integer> operation;

    public OperationInstruction(BiFunction<Integer, Integer, Integer> operation) {
        this.operation = operation;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        int paramA = parameters[0].getAdjustedValue(memory);
        int paramB = parameters[1].getAdjustedValue(memory);

        memory.store(operation.apply(paramA, paramB), parameters[2].getValue());
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
