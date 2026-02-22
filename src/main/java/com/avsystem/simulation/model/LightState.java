package com.avsystem.simulation.model;

public enum LightState {
    RED,
    SHORT_YELLOW,
    GREEN,
    GREEN_ARROW,
    LONG_YELLOW;

    public boolean allowsPassage() {
        return this == GREEN || this == GREEN_ARROW || this == LONG_YELLOW;
    }
}
