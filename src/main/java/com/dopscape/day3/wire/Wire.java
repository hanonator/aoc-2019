package com.dopscape.day3.wire;

import java.util.Set;

public class Wire {

    private final String name;
    private final Set<WireNode> wireNodes;

    public Wire(String name, Set<WireNode> wireNodes) {
        this.name = name;
        this.wireNodes = wireNodes;
    }

    public String getName() {
        return name;
    }

    public Set<WireNode> getWireNodes() {
        return wireNodes;
    }

}
