package com.dopscape;

import com.dopscape.wire.WireNode;
import com.dopscape.wire.Wire;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Panel {

    public static final WireNode CONNECTOR_ORIGIN = new WireNode(10_000, 10_000, 0);

    private final Set<Wire> wires = new LinkedHashSet<>();


    public Set<WireNode> intersectingPoints() {
        Set<WireNode> control = new HashSet<>();
        Set<WireNode> intersections = new HashSet<>();

        for (Wire wire : wires) {
            for (WireNode wireNode : wire.getWireNodes()) {
                if (!control.add(wireNode)) {
                    WireNode existingNode = control.stream().filter(wireNode::equals).findAny().orElseThrow();
                    intersections.add(new WireNode(wireNode, wireNode.getIndex() + existingNode.getIndex()));
                }
            }
        }
        return intersections;
    }

    public void addWire(Wire wire) {
        this.wires.add(wire);
    }

}
