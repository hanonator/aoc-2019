package com.dopscape.day10;

import java.util.*;

public class Map {

    private final List<Asteroid> asteroids;

    public Map(List<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    public static Map of(List<String> lines) {
        var asteroids = new ArrayList<Asteroid>();
        for (int x = 0; x < lines.get(0).length(); x++) {
            for (int y = 0; y < lines.size(); y++) {
                if (lines.get(y).charAt(x) == '#') {
                    asteroids.add(new Asteroid(x, y));
                }
            }
        }
        return new Map(asteroids);
    }


    public Optional<Station> getClosestStation() {
        Station station = null;
        for (Station possible : listAvailableStations()) {
            if (station == null || possible.getVisibleAsteroids() > station.getVisibleAsteroids())
                station = possible;
        }
        return Optional.of(station);
    }

    private Set<Station> listAvailableStations() {
        var stations = new HashSet<Station>();
        for (Asteroid asteroid : asteroids) {
            var angles = new HashSet<Double>();

            for (Asteroid other : asteroids) {
                if (asteroid == other)
                    continue;
                angles.add(Math.atan2(asteroid.getY() - other.getY(), asteroid.getX() - other.getX()));
            }
            stations.add(new Station(asteroid.getX(), asteroid.getY(), angles.size()));
        }
        return stations;
    }
}
