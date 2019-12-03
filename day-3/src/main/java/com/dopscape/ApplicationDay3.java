package com.dopscape;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationDay3 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(Wires.intersections(Files.readAllLines(
                Paths.get(ApplicationDay3.class.getClassLoader().getResource("input_day3.txt").toURI())).stream()
                .map(Wires::build).collect(Collectors.toSet()))
                .stream()
                .mapToInt(Coordinate.ORIGIN::distance).min().getAsInt());
    }

}
