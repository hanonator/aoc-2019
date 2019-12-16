package com.dopscape.intcode.processor.instruction;

import com.dopscape.intcode.Memory;
import com.dopscape.intcode.processor.Parameter;

public interface Instruction {

    void execute(Memory memory, Parameter[] params);

    int length();

}
