package com.dopscape.computer.memory;

public interface Memory {

    void store(int value, int address);

    int[] read(int length);

    int get(int address);

    int skip(int steps);

    int position();

    void position(int position);

    int limit();

    default int get() {
        return get(this.position());
    }

    default int read() {
        return read(1)[0];
    }

}
