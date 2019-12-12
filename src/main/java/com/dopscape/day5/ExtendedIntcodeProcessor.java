package com.dopscape.day5;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.AbstractProcessor;
import com.dopscape.computer.processor.instruction.Instruction;
import com.dopscape.computer.processor.instruction.InstructionSet;
import com.dopscape.computer.processor.instruction.Mode;
import com.dopscape.computer.processor.instruction.Parameter;

public class ExtendedIntcodeProcessor extends AbstractProcessor {

    public ExtendedIntcodeProcessor(InstructionSet instructionSet) {
        super(instructionSet);
    }

    @Override
    protected Parameter[] getParameters(Memory memory, Instruction instruction, int opcode) {
        int[] modes = opcode > 0 ? convertToArray(opcode) : new int[0];
        Parameter[] parameters = new Parameter[instruction.getParameterCount()];

        for (int i = 0; i < parameters.length; i++) {
            Mode mode = modes.length > i ? Mode.values()[modes[i]] : Mode.POSITION;
            int value = memory.get(memory.position() + i + 1);

            parameters[i] = new Parameter(value, mode);
        }

        return parameters;
    }

    private int[] convertToArray(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException();
        }
        int[] output = new int[(int) (Math.log10(input) + 1)];
        for (int i = 0; i < output.length; i++) {
            output[i] = input % 10;
            input /= 10;
        }
        return output;
    }

}
