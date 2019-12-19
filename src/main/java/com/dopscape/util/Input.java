package com.dopscape.util;

import com.dopscape.day2.IntcodeApplication;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Input {

    public static long[] readIntArray(String filename) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(Resources.getResource(filename).toURI()))
                .stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .mapToLong(Long::valueOf)
                .toArray();
    }

}
