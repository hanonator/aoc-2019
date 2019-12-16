package com.dopscape.day5;

import com.dopscape.intcode.processor.instruction.InstructionSet;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOInstructionSet extends InstructionSet {

    public IOInstructionSet(Supplier<Long> in, Consumer<Long> out) {
        super(in, out);
    }

    public IOInstructionSet(Supplier<Long> in) {
        super(in, System.out::println);
    }

}
