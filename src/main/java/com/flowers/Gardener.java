package com.flowers;

import javax.naming.Name;
import java.util.List;

public class Gardener {

    private final String name;
    private final List<Flower> assignedFlowers;

    public Gardener(String name, List<Flower> assignedFlowers) {
        this.name = name;
        this.assignedFlowers = assignedFlowers;
    }

    public String getName() {
        return name;
    }

    public List<Flower> getAssignedFlowers() {
        return assignedFlowers;
    }

    @Override
    public String toString() {
        return name + " : (assigned flowers) " +assignedFlowers;
    }
}
