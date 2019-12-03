package com.dopscape;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveRocketFuelCalculatorTest {

    @ParameterizedTest
    @MethodSource("createRecursiveInputSources")
    public void testSimpleRocketCalculator(int input, int output) {
        RocketFuelCalculator calculator = new RecursiveRocketFuelCalculator();

        assertThat(calculator.calculateTotal(input)).isEqualTo(output);
    }

    private static Stream<Arguments> createRecursiveInputSources() {
        return Stream.of(
                Arguments.of(14, 2),
                Arguments.of(1969, 966),
                Arguments.of(100756, 50346));
    }

}
