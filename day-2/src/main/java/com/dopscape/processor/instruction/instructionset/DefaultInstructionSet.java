package com.dopscape.processor.instruction.instructionset;

import com.dopscape.processor.instruction.*;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DefaultInstructionSet implements InstructionSet{

    private static final Map<Integer, Instruction> instructionSet = new HashMap<>();
    private static final Instruction UNSUPPORTED_INSTRUCTION = new UnsupportedInstruction();

    public DefaultInstructionSet(Supplier<Integer> in, OutputStream out) {
        instructionSet.put(1, new OperationInstruction(Integer::sum));
        instructionSet.put(2, new OperationInstruction((a, b) -> a * b));

        instructionSet.put(3, new ReadInstruction(in));
        instructionSet.put(4, new WriteInstruction(out));

        instructionSet.put(5, new ConditionalJumpInstruction(i -> i != 0));
        instructionSet.put(6, new ConditionalJumpInstruction(i -> i == 0));

        instructionSet.put(7, new CompareAndStoreInstruction((a, b) -> a < b));
        instructionSet.put(8, new CompareAndStoreInstruction(Integer::equals));

        instructionSet.put(99, new ExitInstruction());
    }

    public Instruction get(int instructionId) {
        return instructionSet.getOrDefault(instructionId, UNSUPPORTED_INSTRUCTION);
    }

}
