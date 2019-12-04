package com.dopscape;

import com.dopscape.wire.Wire;
import com.dopscape.wire.WireNode;
import com.dopscape.wire.Wires;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class WireApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Panel panel = new Panel();

        Set<Wire> wires = Files.readAllLines(Paths.get(ClassLoader.getSystemClassLoader().getResource("input_day3.txt").toURI()))
                .stream().map(Wires::build).collect(Collectors.toSet());
        wires.forEach(panel::addWire);

        // Part 1
        System.out.print("Result: " + panel.intersectingPoints().stream().mapToInt(Panel.CONNECTOR_ORIGIN::distance).min().orElseThrow());

        // Part 2
        System.out.print("Result: " + panel.intersectingPoints().stream().mapToInt(WireNode::getIndex).min().orElseThrow());
    }

}
