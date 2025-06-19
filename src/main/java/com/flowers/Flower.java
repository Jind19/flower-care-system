package com.flowers;

import java.util.List;

public class Flower {

    private final String name;
    private final List<String> careActions;

    public Flower(String name, List<String> careActions) {
        this.name = name;
        this.careActions = careActions;
    }

    public String getName() {
        return name;
    }

    public List<String> getCareActions() {
        return careActions;
    }

    @Override
    public String toString() {
        return name + " : " + careActions;
    }
}
