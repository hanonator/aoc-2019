package com.dopscape.day3.wire;

import java.util.Objects;

public class WireNode {

    private final int x;
    private final int y;
    private int absoluteDistance;

    public WireNode(int x, int y, int absoluteDistance) {
        this.x = x;
        this.y = y;
        this.absoluteDistance = absoluteDistance;
    }

    public WireNode(WireNode other, int absoluteDistance) {
        this (other.x, other.y, absoluteDistance);
    }

    public int distance(WireNode other) {
        return Math.abs(other.x - x) + Math.abs(other.y - y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WireNode wireNode = (WireNode) o;
        return x == wireNode.x && y == wireNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "WireNode{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return absoluteDistance;
    }
}
