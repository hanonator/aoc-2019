package com.dopscape.day2;

import com.dopscape.intcode.memory.ArrayMemory;
import com.dopscape.intcode.processor.SimpleProcessor;
import com.dopscape.util.Input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class IntcodeApplication {

    private static final int RANGE = 100;
    private static final int TARGET_NUMBER = 19690720;

    public static void main(String[] args) throws URISyntaxException, IOException {
        long[] input = Input.readIntArray("day2-input");

        // part 1
        var part1 = new ArrayMemory(Arrays.copyOf(input, input.length));
        var processor = new SimpleProcessor(part1, new SimpleInstructionSet());

        part1.write(12, 1);
        part1.write(2, 2);

        processor.process();

        System.out.println(part1.peek(0));

        // part 2
        for (int noun = 0; noun < RANGE; noun++) {
            for (int verb = 0; verb < RANGE; verb++) {
                var memory = new ArrayMemory(Arrays.copyOf(input, input.length));
                var computer = new SimpleProcessor(memory, new SimpleInstructionSet());

                memory.write(noun, 1);
                memory.write(verb, 2);

                computer.process();

                if (memory.peek(0) == TARGET_NUMBER) {
                    System.out.println(noun + "" + verb);
                    return;
                }
            }
        }
    }

}
