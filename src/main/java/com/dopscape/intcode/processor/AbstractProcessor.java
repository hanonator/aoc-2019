package com.dopscape.intcode.processor;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.Processor;
import com.dopscape.intcode.processor.instruction.InstructionSet;

public abstract class AbstractProcessor implements Processor {

    private final Memory memory;
    private final InstructionSet instructionSet;

    public AbstractProcessor(Memory memory, InstructionSet instructionSet) {
        this.memory = memory;
        this.instructionSet = instructionSet;
    }

    @Override
    public void process() {
        while (memory.pointer() != Memory.EOF) {
            var pointer = memory.pointer();

            var instruction = this.instructionSet.get((int) memory.peek() % 100);
            var parameters = this.getParameters((int) memory.peek() / 100, instruction.length());

            instruction.execute(memory, parameters);

            if (pointer == memory.pointer())
                memory.skip(instruction.length() + 1);
        }
    }

    private Parameter[] getParameters(int instruction, int length) {
        var parameters = new Parameter[length];
        for (int i = 0; i < length; i++) {
            var value = memory.peek(memory.pointer() + 1 + i);
            parameters[i] = new Parameter(ParameterMode.values()[instruction % 10], value);

            instruction /= 10;
        }
        return parameters;
    }

}
