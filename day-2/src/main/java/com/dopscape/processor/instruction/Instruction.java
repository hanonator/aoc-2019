package com.dopscape.processor.instruction;

import com.dopscape.memory.Memory;

public interface Instruction {

    /**
     *
     * @param parameters
     */
    void execute(Memory memory, int[] parameters);

    /**
     *
     * @return
     */
    int getParameterCount();

}
