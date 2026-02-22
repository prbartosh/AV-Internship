package com.avsystem.simulation.model;

public enum RoadDirection {
    NORTH, SOUTH, EAST, WEST;

    public RoadDirection opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }

    // do parsowania json'a
    public static RoadDirection fromString(String s) {
        return valueOf(s.toUpperCase());
    }
}
