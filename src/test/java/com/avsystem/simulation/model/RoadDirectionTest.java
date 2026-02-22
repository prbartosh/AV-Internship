package com.avsystem.simulation.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoadDirectionTest {


    @Test
    void shouldReturnOppositeDirection() {
        assertEquals(RoadDirection.NORTH, RoadDirection.SOUTH.opposite());
        assertEquals(RoadDirection.SOUTH, RoadDirection.NORTH.opposite());
        assertEquals(RoadDirection.WEST, RoadDirection.EAST.opposite());
        assertEquals(RoadDirection.EAST, RoadDirection.WEST.opposite());
    }

}
