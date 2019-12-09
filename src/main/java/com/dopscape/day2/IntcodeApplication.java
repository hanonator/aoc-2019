package com.dopscape.day2;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.computer.processor.Processor;
import com.dopscape.computer.processor.instruction.instructionset.DefaultInstructionSet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class IntcodeApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        int[] input = Files.readAllLines(Paths.get(Objects.requireNonNull(IntcodeApplication.class.getClassLoader().getResource("day2-input")).toURI()))
                .stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .mapToInt(Integer::valueOf)
                .toArray();

        new Processor(new ArrayMemory(input), new DefaultInstructionSet(() -> 5, System.out::println)).process();
    }

}
