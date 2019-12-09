package com.dopscape.computer.processor.operation;

import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.instruction.UnsupportedInstruction;

public class AlarmOperation implements UnsupportedInstruction.Operation {

    @Override
    public void process(Memory memory) {
        memory.store(12, 1);
        memory.store(2, 2);
    }

}
