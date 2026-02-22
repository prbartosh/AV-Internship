package com.avsystem.simulation.model;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lane {
    private final RoadDirection direction;
    private final Queue<Vehicle> waitingVehicles;
    private final TrafficLight trafficLight;
    private int totalVehiclesPassed; // dla statystyk

//    droga jest inicjalizowana ze swoim kierunkiem, światłami, oraz zawiera kolejkę samochodów
    public Lane(RoadDirection direction) {
        this.direction = direction;
        this.waitingVehicles = new ArrayDeque<>();
        this.trafficLight = new TrafficLight();
        this.totalVehiclesPassed = 0;
    }

    public void adVehicle(Vehicle vehicle) {
        this.waitingVehicles.offer(vehicle);
    }

    public Vehicle releaseVehicle() {
        if (this.trafficLight.allowsPassage() && !this.waitingVehicles.isEmpty()) {
            this.totalVehiclesPassed++;
            return waitingVehicles.poll();
        }
        return null;
    }

    public int getQueueSize() { return this.waitingVehicles.size(); }
    public RoadDirection getDirection() { return this.direction; }
    public TrafficLight getTrafficLight() { return this.trafficLight; }
    public int getTotalVehiclesPassed() { return this.totalVehiclesPassed; }
    public boolean hasWaitingVehicles() { return !waitingVehicles.isEmpty(); }
}
