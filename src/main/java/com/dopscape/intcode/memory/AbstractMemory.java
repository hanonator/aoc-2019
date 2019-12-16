package com.dopscape.intcode.memory;

import com.dopscape.intcode.Memory;

public abstract class AbstractMemory implements Memory {

    private int pointer;
    private int relativeBase;

    @Override
    public void pointer(int address) {
        this.pointer = address;
    }

    @Override
    public int pointer() {
        return pointer;
    }

    @Override
    public int getRelativeBase() {
        return this.relativeBase;
    }

    @Override
    public void adjustRelativeBase(int relativeBase) {
        this.relativeBase += relativeBase;
    }

}
