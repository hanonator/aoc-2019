package com.dopscape;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Wires {

    public static Set<Coordinate> intersections(Collection<Wire> wires) {
        Set<Coordinate> everything = new LinkedHashSet<>();
        Set<Coordinate> intersections = new LinkedHashSet<>();
        for (Wire wire : wires) {
            for (Coordinate coordinate : wire.getPath()) {
                if (everything.contains(coordinate)) {
                    intersections.add(coordinate);
                } else {
                    everything.add(coordinate);
                }
            }
        }
        return intersections;
    }

    public static Wire build(String s) {
        Set<Coordinate> coordinates = new LinkedHashSet<>();
        Coordinate current = Coordinate.ORIGIN;
        for (String command : s.split(",")) {
            Coordinate coordinate = null;
            Direction direction = Direction.valueOf("" + command.charAt(0));
            int steps = Integer.valueOf(command.substring(1));

            for (int i = 0; i < steps; i++) {
                current = direction.offset(current);
                coordinates.add(current);
            }
        }
        return new Wire(coordinates);
    }


    private static enum Direction {
        R(1, 0),
        D(0, -1),
        U(0, 1),
        L(-1, 0);

        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate offset(Coordinate other) {
            return new Coordinate(other.getX() + x, other.getY() + y);
        }

    }

}
