package com.dopscape.intcode.processor.instruction;

import com.dopscape.intcode.processor.instruction.impl.*;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InstructionSet {

    private static final Instruction UNSUPPORTED_INSTRUCTION = new UnsupportedInstruction();
    private Map<Integer, Instruction> instructions;

    public InstructionSet(Supplier<Long> in, Consumer<Long> out) {
        this.instructions = Map.of(
                1, new OperationInstruction(Long::sum),
                2, new OperationInstruction((a, b) -> a * b),

                3, new ReadInstruction(in),
                4, new WriteInstruction(out),

                5, new ConditionalJumpInstruction(i -> i != 0),
                6, new ConditionalJumpInstruction(i -> i == 0),

                7, new CompareAndStoreInstruction((a, b) -> a < b),
                8, new CompareAndStoreInstruction(Long::equals),

                9, new RelativeBaseInstruction(),

                99, new ExitInstruction()
        );
    }

    public Instruction get(int opcode) {
        return instructions.getOrDefault(opcode, UNSUPPORTED_INSTRUCTION);
    }

}
