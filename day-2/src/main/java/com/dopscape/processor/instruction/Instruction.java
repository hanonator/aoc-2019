package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;
import com.dopscape.processor.Parameter;

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
