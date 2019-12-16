package com.dopscape.intcode.memory;

import com.dopscape.intcode.Memory;

import java.util.ArrayList;

public class IOMemory extends AbstractMemory {

    private final ArrayList<Long> memory;

    public IOMemory(ArrayList<Long> memory) {
        this.memory = memory;
    }

    public static IOMemory wrap(long[] input) {
        var list = new ArrayList<Long>();
        for (long l : input)
            list.add(l);
        return new IOMemory(list);
    }

    @Override
    public Memory write(long value, int address) {
        memory.set(address, value);
        return this;
    }

    @Override
    public long read(int address) {
        return memory.get(address);
    }

}
