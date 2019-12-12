package com.dopscape.computer.processor;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Processor;
import com.dopscape.computer.processor.instruction.Instruction;
import com.dopscape.computer.processor.instruction.InstructionSet;
import com.dopscape.computer.processor.instruction.Mode;
import com.dopscape.computer.processor.instruction.Parameter;

public abstract class AbstractProcessor implements Processor {

    private final InstructionSet instructionSet;

    public AbstractProcessor(InstructionSet instructionSet) {
        this.instructionSet = instructionSet;
    }

    public Processor process(Memory memory) {
        while (memory.position() < memory.limit()) {
            int currentPos = memory.position();

            Instruction instruction = instructionSet.get(memory.read() % 100);
            instruction.execute(memory, getParameters(memory, instruction, memory.read() / 100));

            if (memory.position() == currentPos)
                memory.skip(instruction.getParameterCount() + 1);

        }
        return this;
    }

    protected abstract Parameter[] getParameters(Memory memory, Instruction instruction, int opcode);

}
