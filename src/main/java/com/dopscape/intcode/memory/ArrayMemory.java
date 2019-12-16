package com.dopscape.intcode.memory;

import com.dopscape.intcode.Memory;

public class ArrayMemory extends AbstractMemory {

    private final long[] memory;

    public ArrayMemory(long... memory) {
        this.memory = memory;
    }

    @Override
    public Memory write(long value, int address) {
        memory[address] = value;
        return this;
    }

    @Override
    public long peek(int address) {
        return memory[address];
    }

    @Override
    public int capacity() {
        return memory.length;
    }
}
