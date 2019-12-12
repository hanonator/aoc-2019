package com.dopscape.computer.processor.instruction.impl;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.Parameter;
import com.dopscape.computer.processor.instruction.Instruction;

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
