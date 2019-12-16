package com.dopscape.day9;

import com.dopscape.day5.IOInstructionSet;
import com.dopscape.intcode.memory.ArrayMemory;
import com.dopscape.intcode.memory.ListMemory;
import com.dopscape.intcode.processor.SimpleProcessor;
import com.dopscape.util.Input;

import java.io.IOException;
import java.net.URISyntaxException;

public class RelativeInstructionSetApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var memory = ListMemory.wrap(Input.readIntArray("day9-input"));
        var processor = new SimpleProcessor(memory, new IOInstructionSet(() -> 1L));
        processor.process();

        memory = ListMemory.wrap(Input.readIntArray("day9-input"));
        processor = new SimpleProcessor(memory, new IOInstructionSet(() -> 2L));
        processor.process();
    }

}
