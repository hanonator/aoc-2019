package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.processor.instruction.Instruction;

public abstract class AbstractInstruction implements Instruction {

    private final int length;

    public AbstractInstruction(int length) {
        this.length = length;
    }

    @Override
    public int length() {
        return this.length;
    }

}
