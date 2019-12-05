package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

public class UnsupportedInstruction implements Instruction {

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        throw new UnsupportedOperationException("no instruction found for opcode [" + memory.get() + "]");
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

}
