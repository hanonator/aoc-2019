package com.dopscape;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionTest {

    @ParameterizedTest
    @MethodSource("providesTestVariables")
    public void testIntersections(String input, int distance) {
        assertThat(Wires.intersections(Stream.of(input.split("\n"))
                .map(Wires::build).collect(Collectors.toSet()))
                .stream()
                .mapToInt(Coordinate.ORIGIN::distance).min().getAsInt())
                .isEqualTo(distance);
    }

    private static Stream<Arguments> providesTestVariables() {
        return Stream.of(
                Arguments.of("R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                        "U62,R66,U55,R34,D71,R55,D58,R83", 159),
                Arguments.of("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n" +
                        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 135));
    }

}
