package com.dopscape.intcode;

import com.dopscape.intcode.processor.Parameter;

public interface Memory {

    int EOF = -1;

    Memory write(long value, int address);

    long peek(int address);

    void pointer(int address);

    int pointer();

    int getRelativeBase();

    void adjustRelativeBase(int relativeBase);

    default void write(long value, Parameter param) {
        switch (param.getMode()) {
            case POSITION:
                this.write(value, (int) param.getValue());
                break;
            case RELATIVE:
                this.write(value, getRelativeBase() + (int) param.getValue());
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    default long read(Parameter param) {
        return param.getMode().extract(this, param.getValue());
    }

    default void skip(int amount) {
        this.pointer(this.pointer() + amount);
    }

    default long peek() {
        return this.peek(this.pointer());
    }

    int capacity();
}
