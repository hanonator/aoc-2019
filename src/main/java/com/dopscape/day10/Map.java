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

    public Optional<Asteroid> vaporize() {
        var origin = getStation().orElseThrow();
        var sorted = new TreeMap<Double, TreeSet<CoolAsteroid>>();

        for (Asteroid asteroid : asteroids) {
            var angle = Math.toDegrees(Math.atan2(origin.getY() - asteroid.getY(), origin.getX() - asteroid.getX()));

            if (angle < 90) {
                angle += 360;
            }

            sorted.computeIfAbsent(angle, a -> new TreeSet<>()).add(new CoolAsteroid(asteroid, distance(origin, asteroid)));
        }

        int index = 0;
        while (!sorted.isEmpty()){
            for (var iterator = sorted.entrySet().iterator(); ; ) {
                var entry = iterator.next();
                var asteroid = entry.getValue().stream().findFirst().orElseThrow();
                entry.getValue().remove(asteroid);

                if (entry.getValue().isEmpty()) {
                    iterator.remove();
                }

                if (++index == 200)
                    return Optional.of(asteroid);

            }
        }
        throw new IllegalStateException("no asteroid found yo");
    }


    public Optional<Station> getStation() {
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

    private int distance(Asteroid origin, Asteroid other) {
        return Math.abs(origin.getX() - other.getX()) + Math.abs(origin.getY() - other.getY());
    }

    public void problem(Asteroid origin) {
        var sorted = new TreeMap<Double, TreeSet<CoolAsteroid>>();

        for (Asteroid asteroid : asteroids) {
            var angle = Math.toDegrees(Math.atan2(origin.getY() - asteroid.getY(), origin.getX() - asteroid.getX()));

            if (angle < 90) {
                angle += 360;
            }

            sorted.computeIfAbsent(angle, a -> new TreeSet<>()).add(new CoolAsteroid(asteroid, distance(origin, asteroid)));
        }

        int last_angle = 0;
        while (!sorted.isEmpty()){
            for (var iterator = sorted.entrySet().iterator(); iterator.hasNext();) {
                var entry = iterator.next();
                var asteroid = entry.getValue().stream().findFirst().orElseThrow();
                entry.getValue().remove(asteroid);

                if (entry.getValue().isEmpty()) {
                    iterator.remove();
                }

                System.out.println(asteroid);
            }
        }
    }
}
