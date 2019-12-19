package com.dopscape.day11;

import java.util.Objects;

public class Panel {

    private final int x;
    private final int y;
    private long color;

    public Panel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panel panel = (Panel) o;
        return x == panel.x &&
                y == panel.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Panel{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }
}
