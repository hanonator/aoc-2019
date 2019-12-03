package com.dopscape.processor.operation;

import com.dopscape.memory.Memory;
import com.dopscape.processor.instruction.*;

import java.util.HashMap;
import java.util.Map;

public class ProcessingOperation implements Operation {

    private static final Map<Integer, Instruction> instructionSet = new HashMap<>();

    static {
        instructionSet.put(1, new AdditionInstruction());
        instructionSet.put(2, new MultiplicationInstruction());
        instructionSet.put(99, new ExitInstruction());
    }

    @Override
    public void process(Memory memory) {
        while (memory.position() < memory.limit()) {
            Instruction instruction = instructionSet.getOrDefault(memory.step(), new UnsupportedInstruction());
            instruction.execute(memory, memory.read(instruction.getParameterCount()));
            memory.step(instruction.getParameterCount());
        }
    }



}
