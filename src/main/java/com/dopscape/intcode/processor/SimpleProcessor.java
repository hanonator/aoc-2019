package com.dopscape.intcode.processor;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.instruction.InstructionSet;

public class SimpleProcessor extends AbstractProcessor {

    public SimpleProcessor(Memory memory, InstructionSet instructionSet) {
        super(memory, instructionSet);
    }

}
