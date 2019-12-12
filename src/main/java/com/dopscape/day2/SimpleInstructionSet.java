package com.dopscape.day2;

import com.dopscape.computer.processor.instruction.Instruction;
import com.dopscape.computer.processor.instruction.InstructionSet;
import com.dopscape.computer.processor.instruction.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SimpleInstructionSet implements InstructionSet {

    private static final Map<Integer, Instruction> instructionSet = new HashMap<>();
    private static final Instruction UNSUPPORTED_INSTRUCTION = new UnsupportedInstruction();

    public SimpleInstructionSet() {
        instructionSet.put(1, new OperationInstruction(Integer::sum));
        instructionSet.put(2, new OperationInstruction((a, b) -> a * b));

        instructionSet.put(99, new ExitInstruction());
    }

    public Instruction get(int instructionId) {
        return instructionSet.getOrDefault(instructionId, UNSUPPORTED_INSTRUCTION);
    }

}
