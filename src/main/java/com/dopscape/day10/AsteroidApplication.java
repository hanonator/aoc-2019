package com.dopscape.day10;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AsteroidApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        var map = Map.of(Files.readAllLines(Path.of(Resources.getResource("day10-input").toURI())));

        System.out.println(map.getStation().orElseThrow());
    }

}
