package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;

public class UnsupportedInstruction implements Instruction {

    @Override
    public void execute(Memory memory, int[] parameters) {
        throw new UnsupportedOperationException("no instruction found for opcode [" + memory.step(-1) + "]");
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

}
