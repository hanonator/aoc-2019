package com.dopscape.day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class GraphApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Universe testUniverse = Universe.load(Paths.get(ClassLoader.getSystemResource("day6-input").toURI()));

        System.out.println(testUniverse.getTotalOrbits());
    }

}
