package com.avsystem.simulation.model;

public record Vehicle(
       String vehicleID,
       RoadDirection startRoad,
       RoadDirection endRoad
) {}
