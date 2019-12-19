package com.dopscape.day11;

public enum Direction {
    LEFT(-1, 0),
    UP(0, 1),
    RIGHT(1, 0),
    DOWN(0, -1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction turnLeft() {
        return values()[Math.abs((ordinal() - 1)) % values().length];
    }

    public Direction turnRight() {
        return values()[Math.abs((ordinal() + 1)) % values().length];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
