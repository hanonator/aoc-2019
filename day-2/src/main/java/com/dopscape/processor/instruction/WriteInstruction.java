package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteInstruction implements Instruction {

    private static final int PARAMETER_COUNT = 1;

    private final PrintWriter out;

    public WriteInstruction(OutputStream out) {
        this.out = new PrintWriter(out);
    }

    @Override
    public void execute(Memory memory, Parameter[] parameters) {
        out.println("[" + parameters[0].getValue() + "] = " + parameters[0].getAdjustedValue(memory));
        out.flush();
    }

    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

}
