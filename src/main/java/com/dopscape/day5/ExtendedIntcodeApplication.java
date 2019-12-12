package com.dopscape.day5;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.computer.processor.Processor;
import com.dopscape.day2.IntcodeApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class ExtendedIntcodeApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        int[] input = Files.readAllLines(Paths.get(IntcodeApplication.class.getClassLoader().getResource("day5-input").toURI()))
                .stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .mapToInt(Integer::valueOf)
                .toArray();

        new ExtendedIntcodeProcessor(new ArrayMemory(input), new ExtendedInstructionSet(() -> 5, System.out::println)).process();
    }

}
