package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

public class ExitInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 0;

    public ExitInstruction() {
        super(PARAMETER_COUNT);
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        memory.pointer(Memory.EOF);
    }

}
