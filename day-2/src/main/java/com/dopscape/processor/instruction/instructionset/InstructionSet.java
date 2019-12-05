package com.dopscape.processor.instruction.instructionset;

import com.dopscape.processor.instruction.Instruction;

public interface InstructionSet {

    Instruction get(int instructionId);

}
