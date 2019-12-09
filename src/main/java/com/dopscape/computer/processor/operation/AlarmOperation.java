package com.dopscape.day2.processor.operation;

import com.dopscape.day2.processor.instruction.UnsupportedInstruction;
import com.dopscape.memory.Memory;

public class AlarmOperation implements UnsupportedInstruction.Operation {

    @Override
    public void process(Memory memory) {
        memory.store(12, 1);
        memory.store(2, 2);
    }

}
