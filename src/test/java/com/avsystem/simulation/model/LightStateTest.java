package com.avsystem.simulation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightStateTest {

    @Test
    void shouldAllowToPassOnGreenAndGreenArrowAndLongYellow() {
        assertTrue(LightState.GREEN.allowsPassage());
        assertTrue(LightState.GREEN_ARROW.allowsPassage());
        assertTrue(LightState.LONG_YELLOW.allowsPassage());
    }

    @Test
    void shouldNotAllowToPassOnRedAndShortYellow() {
        assertFalse(LightState.RED.allowsPassage());
        assertFalse((LightState.SHORT_YELLOW.allowsPassage()));
    }
}
