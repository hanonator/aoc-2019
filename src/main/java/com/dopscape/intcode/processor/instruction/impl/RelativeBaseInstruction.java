package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

public class RelativeBaseInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 1;

    public RelativeBaseInstruction() {
        super(PARAMETER_COUNT);
    }

    @Override
    public void execute(Memory memory, Parameter[] params) {
        memory.adjustRelativeBase((int) memory.read(params[0]));
    }
}
