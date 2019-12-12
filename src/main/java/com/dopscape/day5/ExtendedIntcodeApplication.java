package com.dopscape.day5;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.util.Input;

import java.io.IOException;
import java.net.URISyntaxException;

public class ExtendedIntcodeApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        int[] input = Input.readIntArray("day2-input");
        new ExtendedIntcodeProcessor(new ArrayMemory(input), new ExtendedInstructionSet(() -> 5, System.out::println)).process();
    }

}
