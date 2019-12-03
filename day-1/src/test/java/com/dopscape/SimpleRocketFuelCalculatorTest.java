package com.dopscape;

import org.assertj.core.annotations.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleRocketFuelCalculatorTest {

    @ParameterizedTest
    @MethodSource("createSimpleInputSources")
    public void testSimpleRocketCalculator(int input, int output) {
        RocketFuelCalculator calculator = new SimpleRocketFuelCalculator();

        assertThat(calculator.calculateTotal(input)).isEqualTo(output);
    }

    private static Stream<Arguments> createSimpleInputSources() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 654),
                Arguments.of(100756, 33583));
    }
}
