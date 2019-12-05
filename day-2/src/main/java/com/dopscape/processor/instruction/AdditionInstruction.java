package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

import java.util.Arrays;

public class AdditionInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 3;

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        int termA = parameters[0].getAdjustedValue(memory);
        int termB = parameters[1].getAdjustedValue(memory);

        memory.put(termA + termB, parameters[2].getValue());
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
