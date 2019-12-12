package com.dopscape.computer.processor.instruction;

import com.dopscape.computer.memory.Memory;

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
