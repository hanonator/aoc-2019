package com.dopscape.computer.processor.instruction.instructionset;

import com.dopscape.computer.processor.instruction.Instruction;

public interface InstructionSet {

    Instruction get(int instructionId);

}
