package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;
import com.dopscape.intcode.processor.instruction.Instruction;

public class IOInstruction implements Instruction {

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        
    }

    @Override
    public int length() {
        return 1;
    }

}
