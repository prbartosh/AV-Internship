package com.avsystem.simulation.model;

// TrafficLight przechowuje stan światła i liczbę kroków w obecnym stanie
// z TrafficLight można odczytać obecny kolor światła i info czy można jechać
public class TrafficLight {
    private static final int DEFAULT_SHORT_YELLOW_DURATION = 1;
    private static final int DEFAULT_LONG_YELLOW_DURATION = 1;

    private LightState state;
    private int stepsInCurrentState;

    private LightState pendingState;
    private final int shortYellowDuration;
    private final int longYellowDuration;

    public TrafficLight() {
        this(DEFAULT_SHORT_YELLOW_DURATION, DEFAULT_LONG_YELLOW_DURATION);
    }

    public TrafficLight(int shortYellowDuration, int longYellowDuration) {
        this.state = LightState.RED;
        this.stepsInCurrentState = 0;
        this.pendingState = null;
        this.shortYellowDuration = shortYellowDuration;
        this.longYellowDuration = longYellowDuration;
    }

    public void setState(LightState newState) {
        boolean currentlyRed = (this.state == LightState.RED);
        boolean currentlyGreen = (this.state == LightState.GREEN
                                || this.state == LightState.GREEN_ARROW);
        boolean targetIsGreen = (newState == LightState.GREEN
                                || this.state == LightState.GREEN_ARROW);
        boolean targetIsRed = (newState == LightState.RED);

        if (currentlyRed && targetIsGreen) {
            // red -> short_yellow -> green/green_arrow
            this.state = LightState.SHORT_YELLOW;
            this.pendingState = newState;
            this.stepsInCurrentState = 0;
        } else if (currentlyGreen && targetIsRed) {
            this.state = LightState.LONG_YELLOW;
            this.pendingState = newState;
            this.stepsInCurrentState = 0;
        } else {
            this.state = newState;
            this.pendingState = null;
            this.stepsInCurrentState = 0;
        }
    }

    public void tick() {
        this.stepsInCurrentState++;

        if (this.pendingState == null) { return; }

        boolean shortYellowExpired = (this.state == LightState.SHORT_YELLOW
                && this.stepsInCurrentState >= this.shortYellowDuration);
        boolean longYellowExpired = (this.state == LightState.LONG_YELLOW
                && this.stepsInCurrentState >= this.longYellowDuration);

        if (shortYellowExpired || longYellowExpired) {
            this.state = this.pendingState;
            this.pendingState = null;
            this.stepsInCurrentState = 0;
        }
    }

    public boolean isTransitioning() { return this.pendingState != null; }
    public boolean allowsPassage() { return this.state.allowsPassage();  }
    public LightState getState() { return this.state; }
    public int getStepsInCurrentState() { return this.stepsInCurrentState;}
    public LightState getPendingState() { return this.pendingState; }
    public int getShortYellowDuration() { return shortYellowDuration; }
    public int getLongYellowDuration() { return this.longYellowDuration; }


}
