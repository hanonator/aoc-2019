package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;

public class MultiplicationInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 3;

    @Override
    public void execute(Memory memory, int[] parameters) {
        memory.put(memory.get(parameters[0]) * memory.get(parameters[1]), parameters[2]);
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
