package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

public class MultiplicationInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 3;

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        int factorA = parameters[0].getAdjustedValue(memory);
        int factorB = parameters[1].getAdjustedValue(memory);

        memory.put(factorA * factorB, parameters[2].getValue());
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
