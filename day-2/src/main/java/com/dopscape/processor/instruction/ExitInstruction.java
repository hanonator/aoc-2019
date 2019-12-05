package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

public class ExitInstruction implements Instruction {

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        memory.position(memory.limit());
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

}
