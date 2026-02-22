package com.avsystem.simulation.model;

// TrafficLight przechowuje stan światła i liczbę kroków w obecnym stanie
// z TrafficLight można odczytać obecny kolor światła i info czy można jechać
public class TrafficLight {
    private LightState state;
    private int stepsInCurrentState;

    public TrafficLight() {
        this.state = LightState.RED;
        this.stepsInCurrentState = 0;
    }

    public void setState(LightState state) {
        this.state = state;
        this.stepsInCurrentState = 0;
    }

    public void tick() {
        this.stepsInCurrentState++;
    }

    public LightState getState() { return this.state; }
    public int getStepsInCurrentState() { return this.stepsInCurrentState;}
    public boolean allowsPassage() { return this.state.allowsPassage();  }
}
