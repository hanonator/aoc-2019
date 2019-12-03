package com.dopscape;

import java.util.Set;

public class Wire {

    private final Set<Coordinate> path;

    public Wire(Set<Coordinate> path) {
        this.path = path;
    }

    public Set<Coordinate> getPath() {
        return path;
    }
}
