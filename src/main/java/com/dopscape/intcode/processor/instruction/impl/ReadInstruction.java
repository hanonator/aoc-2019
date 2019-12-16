package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;
import com.dopscape.intcode.processor.ParameterMode;

import java.util.function.Supplier;

public class ReadInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 1;

    private final Supplier<Long> supplier;

    public ReadInstruction(Supplier<Long> supplier) {
        super(PARAMETER_COUNT);
        this.supplier = supplier;
    }

    @Override
    public void execute(Memory memory, Parameter[] params) {
        memory.write(supplier.get(), params[0]);
    }

}
