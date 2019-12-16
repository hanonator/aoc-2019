package com.dopscape.intcode.processor.instruction.impl;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

import java.util.function.Consumer;

public class WriteInstruction extends AbstractInstruction {

    private static final int PARAMETER_COUNT = 1;

    private final Consumer<Long> consumer;

    public WriteInstruction(Consumer<Long> consumer) {
        super(PARAMETER_COUNT);
        this.consumer = consumer;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        consumer.accept(memory.read(parameters[0]));
    }

}
