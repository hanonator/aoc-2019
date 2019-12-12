package com.dopscape.computer.processor.instruction;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Parameter;

public class UnsupportedInstruction implements Instruction {

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        throw new UnsupportedOperationException("no instruction found for opcode [" + memory.get() + "]");
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

    public static interface Operation {

        void process(Memory memory);

    }
}
