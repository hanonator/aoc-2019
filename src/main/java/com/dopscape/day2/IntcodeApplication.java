package com.dopscape.day2;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Processor;
import com.dopscape.day5.ExtendedInstructionSet;
import com.dopscape.util.Input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class IntcodeApplication {

    private static final int RANGE = 100;
    private static final int TARGET_NUMBER = 19690720;

    public static void main(String[] args) throws URISyntaxException, IOException {
        int[] input = Input.readIntArray("day2-input");

        // part 1
        var part1 = new ArrayMemory(Arrays.copyOf(input, input.length));
        var processor = new SimpleIntcodeProcessor(new SimpleInstructionSet());

        part1.store(12, 1);
        part1.store(2, 2);

        processor.process(part1);

        System.out.println(part1.get(0));

        // part 2
        for (int noun = 0; noun < RANGE; noun++) {
            for (int verb = 0; verb < RANGE; verb++) {
                var memory = new ArrayMemory(Arrays.copyOf(input, input.length));
                var computer = new SimpleIntcodeProcessor(new SimpleInstructionSet());

                memory.store(noun, 1);
                memory.store(verb, 2);

                computer.process(memory);

                if (memory.get(0) == TARGET_NUMBER) {
                    System.out.println(noun + "" + verb);
                    return;
                }
            }
        }
    }

}
