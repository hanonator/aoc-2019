package com.dopscape.computer.processor.instruction;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Parameter;

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
