package com.dopscape.processor.operation;

import com.dopscape.memory.Memory;

public class AlarmOperation implements Operation {

    @Override
    public void process(Memory memory) {
        memory.store(12, 1);
        memory.store(2, 2);
    }

}
