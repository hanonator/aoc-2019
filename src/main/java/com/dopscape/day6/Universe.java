package com.dopscape.day6;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class Universe {

    private final Graph<String> planets;

    public Universe(Graph<String> planets) {
        this.planets = planets;
    }

    public static Universe load(Path input) throws IOException {
        ImmutableGraph.Builder<String> builder = GraphBuilder.directed().immutable();

        Files.readAllLines(input).stream()
                .map(line -> line.split("\\)"))
                .forEach(part -> builder.putEdge(part[0], part[1]));

        return new Universe(builder.build());
    }

    public int getTotalOrbits(String start) {
        return walkGraph(start, 0);
    }

    private int walkGraph(String planet, int orbits) {
        return orbits + planets.successors(planet).stream().mapToInt(other -> walkGraph(other, orbits+1)).sum();
    }

}
