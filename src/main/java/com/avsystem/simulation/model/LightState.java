package com.avsystem.simulation.model;

public enum LightState {
    RED,
    YELLOW,
    GREEN,
    GREEN_ARROW;

    public boolean allowsPassage() {
        return this == GREEN || this == GREEN_ARROW;
    }
}
