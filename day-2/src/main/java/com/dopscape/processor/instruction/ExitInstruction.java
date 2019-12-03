package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;

public class ExitInstruction implements Instruction {

    @Override
    public void execute(Memory memory, int[] parameters) {
        memory.position(memory.limit());
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

}
