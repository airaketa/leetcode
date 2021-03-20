package com.airaketa.leetcode.lc1396;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Trip> trips = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Trip trip = new Trip();
        trip.id = id;
        trip.startStation = stationName;
        trip.t1 = t;
        trips.put(id, trip);
    }

    public void checkOut(int id, String stationName, int t) {
        Trip trip = trips.get(id);
        trip.endStation = stationName;
        trip.t2 = t;
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] result = new int[2];
        trips.values().stream().filter(trip -> startStation.equals(trip.startStation)
                && endStation.equals(trip.endStation))
                .forEach(trip -> {
                    result[0] += trip.t2 - trip.t1;
                    result[1]++;
                });
        return 1.0 * result[0] / result[1];
    }

    private class Trip {
        int id;
        String startStation;
        String endStation;
        int t1;
        int t2;
    }
}