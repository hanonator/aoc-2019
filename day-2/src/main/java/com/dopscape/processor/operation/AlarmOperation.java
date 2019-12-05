package com.dopscape.processor.operation;

import com.dopscape.memory.Memory;

public class AlarmOperation implements Operation {

    @Override
    public void process(Memory memory) {
        memory.put(12, 1);
        memory.put(2, 2);
    }

}
