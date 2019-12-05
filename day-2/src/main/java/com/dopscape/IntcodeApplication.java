package com.dopscape;

import com.dopscape.memory.ArrayMemory;
import com.dopscape.processor.Processor;
import com.dopscape.processor.instruction.instructionset.DefaultInstructionSet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntcodeApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        int[] input = Files.readAllLines(Paths.get(Objects.requireNonNull(IntcodeApplication.class.getClassLoader().getResource("input.txt")).toURI()))
                .stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .mapToInt(Integer::valueOf)
                .toArray();

        new Processor(new ArrayMemory(input), new DefaultInstructionSet(() -> 5, System.out::println)).process();
    }

}
