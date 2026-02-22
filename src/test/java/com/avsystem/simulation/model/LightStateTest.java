package com.avsystem.simulation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightStateTest {

    @Test
    void shouldAllowToPassOnGreenAndGreenArrow() {
        assertTrue(LightState.GREEN.allowsPassage());
        assertTrue(LightState.GREEN_ARROW.allowsPassage());
    }

    @Test
    void shouldNotAllowToPassOnRedAndYellow() {
        assertFalse(LightState.RED.allowsPassage());
        assertFalse((LightState.YELLOW.allowsPassage()));
    }
}
