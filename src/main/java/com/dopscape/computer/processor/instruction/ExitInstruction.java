package com.dopscape.day2.processor.instruction;

import com.dopscape.day2.memory.Memory;
import com.dopscape.day2.processor.Parameter;

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
