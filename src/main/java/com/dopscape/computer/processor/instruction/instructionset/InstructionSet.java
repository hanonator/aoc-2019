package com.dopscape.day2.processor.instruction.instructionset;

import com.dopscape.day2.processor.instruction.Instruction;

public interface InstructionSet {

    Instruction get(int instructionId);

}
