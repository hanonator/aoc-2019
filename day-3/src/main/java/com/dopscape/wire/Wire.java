package com.dopscape;

import com.dopscape.point.Point;

import java.util.Set;

public class Wire {

    private final String name;
    private final Set<Point> points;

    public Wire(String name, Set<Point> points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Set<Point> getPoints() {
        return points;
    }

}
