package com.dopscape;

import com.dopscape.processor.operation.ProcessingOperation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeComputerTest {

    @ParameterizedTest
    @MethodSource("createSimpleInputSources")
    public void testSimpleIntcodeComputer(int[] input, int[] output) {
        IntcodeComputer computer = new IntcodeComputer(input);
        computer.execute(new ProcessingOperation());
        assertThat(computer.getMemory().dump()).isEqualTo(output);
    }

    private static Stream<Arguments> createSimpleInputSources() {
        return Stream.of(
                Arguments.of(new int[]{
                        1, 0, 0, 0, 99
                }, new int[]{
                        2, 0, 0, 0, 99
                }),
                Arguments.of(new int[]{
                        2, 3, 0, 3, 99
                }, new int[]{
                        2, 3, 0, 6, 99
                }),
                Arguments.of(new int[]{
                        2, 4, 4, 5, 99, 0
                }, new int[]{
                        2, 4, 4, 5, 99, 9801
                }),
                Arguments.of(new int[]{
                        1, 1, 1, 4, 99, 5, 6, 0, 99
                }, new int[]{
                        30, 1, 1, 4, 2, 5, 6, 0, 99
                })
        );
    }

}
