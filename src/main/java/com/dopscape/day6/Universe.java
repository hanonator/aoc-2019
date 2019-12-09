package com.dopscape.day6;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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

    public int getTotalOrbits(String source) {
        return walkGraph(source, 0);
    }

    private int walkGraph(String planet, int orbits) {
        return orbits + planets.successors(planet).stream().mapToInt(other -> walkGraph(other, orbits+1)).sum();
    }

    public int orbitTransfers(String source, String destination) {
        List<String> sourceSteps = trace(new ArrayList<>(), source, "COM").get();
        List<String> destinationSteps = trace(new ArrayList<>(), destination, "COM").get();

        for (String step : sourceSteps) {
            if (destinationSteps.contains(step)) {
                return sourceSteps.indexOf(step) + destinationSteps.indexOf(step) - 2;
            }
        }

        throw new IllegalStateException("paths do not intersect");
    }

    private Optional<List<String>> trace(List<String> path, String source, String destination) {
        path.add(source);
        if (source.equals(destination)) {
            return Optional.of(path);
        }

        String predecessor = planets.predecessors(source).stream().findFirst().orElse(null);
        if (predecessor == null) {
            return Optional.empty();
        }

        return trace(path, predecessor, destination);
    }
}
