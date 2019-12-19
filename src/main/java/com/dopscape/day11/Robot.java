package com.dopscape.day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Robot implements Consumer<Long>, Supplier<Long> {

    private final Set<Panel> panels = new HashSet<>();
    private State state = State.PAINT;
    private Direction direction = Direction.UP;
    private int x;
    private int y;
    private int yo;

    @Override
    public void accept(Long input) {
        switch (state) {
            case DIRECTION:
                direction = input == 0 ? direction.turnLeft() : direction.turnRight();
                x += direction.getX();
                y += direction.getY();
                state = State.PAINT;
                break;

            case PAINT:
                Panel panel = new Panel(x, y);
                panel.setColor(input.intValue());

                panels.add(panel);
                state = State.DIRECTION;
                break;

            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public Long get() {
        return panels.stream().filter(panel -> panel.getX() == x && panel.getY() == y)
                .map(Panel::getColor).findFirst().orElse(0L);
    }

    public int getPanelsPainted() {
        return panels.size();
    }

}
