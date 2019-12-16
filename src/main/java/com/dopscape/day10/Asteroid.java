package com.dopscape.day10;

import java.util.Objects;

public class Asteroid {

    private final int x;
    private final int y;

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Asteroid)) return false;
        Asteroid asteroid = (Asteroid) o;
        return x == asteroid.x &&
                y == asteroid.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
