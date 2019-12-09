package com.dopscape.day3.wire;

import com.dopscape.day3.Panel;

import java.util.LinkedHashSet;
import java.util.Set;

public class Wires {

    public static Wire build(String input) {
        Set<WireNode> coordinates = new LinkedHashSet<>();
        WireNode current = Panel.CONNECTOR_ORIGIN;
        for (String command : input.split(",")) {
            WireNode coordinate = null;
            Direction direction = Direction.valueOf("" + command.charAt(0));
            int steps = Integer.valueOf(command.substring(1));

            for (int i = 0; i < steps; i++) {
                current = direction.offset(current);
                coordinates.add(current);
            }
        }
        return new Wire(input, coordinates);
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

        public WireNode offset(WireNode other) {
            return new WireNode(other.getX() + x, other.getY() + y, other.getIndex() + 1);
        }

    }

}
