package com.dopscape.day10;

public class CoolAsteroid extends Asteroid implements Comparable<CoolAsteroid> {

    private final int distance;

    public CoolAsteroid(Asteroid asteroid, int distance) {
        super(asteroid.getX(), asteroid.getY());
        this.distance = distance;
    }

    public CoolAsteroid(int x, int y, int distance) {
        super(x, y);
        this.distance = distance;
    }

    @Override
    public int compareTo(CoolAsteroid o) {
        return Integer.compare(distance, o.distance);
    }

    @Override
    public String toString() {
        return "CoolAsteroid{" +
                "x" + super.getX() +
                "y" + super.getY() +
                "distance=" + distance +
                '}';
    }
}
