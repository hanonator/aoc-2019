package com.dopscape.processor;

import com.dopscape.memory.ArrayMemory;
import com.dopscape.memory.Memory;
import com.dopscape.processor.instruction.*;
import com.dopscape.processor.instruction.instructionset.InstructionSet;
import com.dopscape.processor.operation.Operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Processor {

    private final Memory memory;
    private final InstructionSet instructionSet;

    public Processor(Memory memory, InstructionSet instructionSet) {
        this.memory = memory;
        this.instructionSet = instructionSet;
    }

    public Processor process() {
        while (memory.position() < memory.limit()) {
            int instructionValue = memory.step();
            Instruction instruction = instructionSet.get(instructionValue % 100);

            int memoryPosition = memory.position();
            int[] modes = instructionValue > 99 ? convertToArray(instructionValue / 100) : new int[0];
            Parameter[] parameters = new Parameter[instruction.getParameterCount()];

            for (int i = 0; i < parameters.length; i++) {
                Mode mode = modes.length > i ? Mode.values()[modes[i]] : Mode.POSITION;
                int value = memory.get(memory.position() + i);

                parameters[i] = new Parameter(value, mode);
            }

            instruction.execute(memory, parameters);

            if (memory.position() == memoryPosition) {
                memory.step(instruction.getParameterCount());
            }
        }
        return this;
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

    public Memory getMemory() {
        return this.memory;
    }

}
