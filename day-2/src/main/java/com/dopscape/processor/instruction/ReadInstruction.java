package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class ReadInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 1;

    private final Supplier<Integer> in;

    public ReadInstruction(Supplier<Integer> in) {
        this.in = in;
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        System.out.println(Arrays.toString(parameters));
        memory.put(in.get(), parameters[0].getValue());
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
