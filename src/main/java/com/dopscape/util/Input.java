package com.dopscape.util;

import com.dopscape.day2.IntcodeApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Input {

    public static int[] readIntArray(String filename) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(IntcodeApplication.class.getClassLoader().getResource(filename).toURI()))
                .stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
