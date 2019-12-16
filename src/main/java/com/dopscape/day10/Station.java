package com.dopscape.day10;

import java.util.Objects;

public class Station extends Asteroid {

    private final int visibleAsteroids;

    public Station(int x, int y, int visibleAsteroids) {
        super(x, y);
        this.visibleAsteroids = visibleAsteroids;
    }

    public int getVisibleAsteroids() {
        return visibleAsteroids;
    }

    @Override
    public String toString() {
        return "Station{" +
                "visibleAsteroids=" + visibleAsteroids +
                "x=" + super.getX() +
                "y=" + super.getY() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return visibleAsteroids == station.visibleAsteroids;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibleAsteroids);
    }
}
