package com.dopscape.intcode.processor.instruction.impl;


import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;
import com.dopscape.intcode.processor.instruction.Instruction;

public class UnsupportedInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 0;

    public UnsupportedInstruction() {
        super(PARAMETER_COUNT);
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        throw new UnsupportedOperationException("no instruction found for opcode [" + memory.peek() + "]");
    }

}
