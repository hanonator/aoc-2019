package com.dopscape.computer.memory;

public class ArrayMemory implements Memory {

    private final int[] memory;
    private int instructionPointer;

    public ArrayMemory(int... memory) {
        this.memory = memory;
    }

    @Override
    public void store(int value, int address) {
        memory[address] = value;
    }

    @Override
    public int[] read(int length) {
        int[] chunk = new int[length];
        for (int i = 0; i < length; i++) {
            chunk[i] = memory[instructionPointer + i];
        }
        return chunk;
    }

    @Override
    public int get(int address) {
        return memory[address];
    }

    @Override
    public int get() {
        return memory[instructionPointer];
    }

    @Override
    public int step() {
        return get(instructionPointer++);
    }

    @Override
    public int step(int steps) {
        return instructionPointer += steps;
    }

    @Override
    public int position() {
        return instructionPointer;
    }

    @Override
    public void position(int position) {
        this.instructionPointer = position;
    }

    @Override
    public int limit() {
        return memory.length;
    }

    @Override
    public int[] dump() {
        return memory;
    }
}
