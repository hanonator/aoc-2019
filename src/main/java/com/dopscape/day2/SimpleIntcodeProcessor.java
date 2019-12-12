package com.dopscape.day2;

import com.dopscape.computer.processor.AbstractProcessor;
import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.Instruction;
import com.dopscape.computer.processor.instruction.InstructionSet;
import com.dopscape.computer.processor.instruction.Mode;
import com.dopscape.computer.processor.instruction.Parameter;

public class SimpleIntcodeProcessor extends AbstractProcessor {

    public SimpleIntcodeProcessor(Memory memory, InstructionSet instructionSet) {
        super(memory, instructionSet);
    }

    @Override
    protected Parameter[] getParameters(Memory memory, Instruction instruction, int opcode) {
        Parameter[] parameters = new Parameter[instruction.getParameterCount()];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = new Parameter(memory.get(memory.position() + 1 + i), Mode.POSITION);
        }
        return parameters;
    }
}
