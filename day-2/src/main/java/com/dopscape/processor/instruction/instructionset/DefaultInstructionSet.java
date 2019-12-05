package com.dopscape.processor.instruction.instructionset;

import com.dopscape.processor.instruction.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DefaultInstructionSet implements InstructionSet{

    private static final Map<Integer, Instruction> instructionSet = new HashMap<>();
    private static final Instruction UNSUPPORTED_INSTRUCTION = new UnsupportedInstruction();

    public DefaultInstructionSet(Supplier<Integer> in, OutputStream out) {
        instructionSet.put(1, new AdditionInstruction());
        instructionSet.put(2, new MultiplicationInstruction());
        instructionSet.put(3, new ReadInstruction(in));
        instructionSet.put(4, new WriteInstruction(out));
        instructionSet.put(99, new ExitInstruction());
    }

    public Instruction get(int instructionId) {
        return instructionSet.getOrDefault(instructionId, UNSUPPORTED_INSTRUCTION);
    }

}
