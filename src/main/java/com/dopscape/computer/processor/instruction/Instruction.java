package com.dopscape.computer.processor.instruction;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Parameter;

public interface Instruction {

    /**
     *
     * @param parameters
     */
    void execute(Memory memory, Parameter[] parameters);

    /**
     *
     * @return
     */
    int getParameterCount();

}
