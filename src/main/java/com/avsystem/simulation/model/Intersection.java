package com.avsystem.simulation.model;

import java.util.*;

public class Intersection {
    private final Map<RoadDirection, Lane> lanes;

    public Intersection() {
        this.lanes = new EnumMap<>(RoadDirection.class);
        for (RoadDirection dir : RoadDirection.values()) {
            lanes.put(dir, new Lane(dir));
        }
    }

    public void addVehicle(String vehicleId, RoadDirection startRoad, RoadDirection endRoad) {
        Vehicle vehicle = new Vehicle(vehicleId, startRoad, endRoad);
        this.lanes.get(startRoad).adVehicle(vehicle);
    }

    public void setGreenLights(List<RoadDirection> greenRoads) {
        for (Map.Entry<RoadDirection, Lane> entry : lanes.entrySet()) {
            LightState state = greenRoads.contains(entry.getKey())
                    ? LightState.GREEN : LightState.RED;
            entry.getValue().getTrafficLight().setState(state);
        }
    }

    public List<String> step() {
        List<String> leftVehicles = new ArrayList<>();
        for (Lane lane : lanes.values()) {
            Vehicle released = lane.releaseVehicle();
            if (released != null) {
                leftVehicles.add(released.vehicleID());
            }
            lane.getTrafficLight().tick();
        }
        return leftVehicles;
    }

    public Map<RoadDirection, Integer> getQueueSizes() {
        Map<RoadDirection, Integer> sizes = new EnumMap<>(RoadDirection.class);
        lanes.forEach((dir, lane) -> sizes.put(dir, lane.getQueueSize()));
        return sizes;
    }

    public Lane getLane(RoadDirection direction) {
        return lanes.get(direction);
    }

    public Map<RoadDirection, Lane> getAllLanes() {
        return Collections.unmodifiableMap(lanes);
    }
}
