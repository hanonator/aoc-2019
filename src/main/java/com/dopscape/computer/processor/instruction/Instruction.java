package com.dopscape.day2.processor.instruction;

import com.dopscape.day2.memory.Memory;
import com.dopscape.day2.processor.Parameter;

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
