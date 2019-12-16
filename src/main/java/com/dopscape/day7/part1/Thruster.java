package com.dopscape.day7.part1;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Thruster implements Supplier<Long>, Consumer<Long> {

    private final int index;
    private Thruster previous;
    private long output;
    private int cycle;

    public Thruster(Thruster previous, int index) {
        this.index = index;
        this.previous = previous;

        System.out.println(index);
    }

    public long getOutput() {
        return output;
    }

    public void setPrevious(Thruster previous) {
        this.previous = previous;
    }

    @Override
    public void accept(Long integer) {
        this.output = integer;
        System.out.println("setting: " + integer);
    }

    @Override
    public Long get() {
        if (previous == null)
            return 0L;
        System.out.println("thruster[" + index + "," + output + "] providing: " + (cycle % 2 == 0 ? index : previous.output));
        return previous.output;
    }

    @Override
    public String toString() {
        return "Thruster{" +
                "previous=" + previous.index +
                ", index=" + index +
                ", output=" + output +
                '}';
    }

    public static class NullThruster extends Thruster {

        public NullThruster() {
            super(null, 0);
        }

    }

}
