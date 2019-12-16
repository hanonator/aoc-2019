package com.dopscape.intcode.memory;

import com.dopscape.intcode.Memory;

import java.util.ArrayList;

public class ListMemory extends AbstractMemory {

    private final ArrayList<Long> memory;

    public ListMemory(ArrayList<Long> memory) {
        this.memory = memory;
    }

    public static ListMemory wrap(long... input) {
        var list = new ArrayList<Long>();
        for (var l : input)
            list.add(l);
        return new ListMemory(list);
    }

    @Override
    public Memory write(long value, int address) {
        while (memory.size() <= address)
            memory.add(0L);
        memory.set(address, value);
        return this;
    }

    @Override
    public long peek(int address) {
        return address > memory.size() ? 0L : memory.get(address);
    }

    @Override
    public int capacity() {
        return memory.size();
    }
}
