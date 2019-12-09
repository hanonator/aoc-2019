package com.dopscape.computer.memory;

public interface Memory {

    void store(int value, int address);

    int[] read(int length);

    int get();

    int step();

    int get(int address);

    int step(int steps);

    int position();

    void position(int position);

    int limit();

    int[] dump();

}
