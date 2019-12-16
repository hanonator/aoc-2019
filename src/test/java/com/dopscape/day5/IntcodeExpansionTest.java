package com.dopscape.day5;

import com.dopscape.intcode.memory.ArrayMemory;
import com.dopscape.intcode.processor.SimpleProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeExpansionTest {

    @Test
    public void test() {
        var memory = new ArrayMemory(1002,4,3,4,33);

        var output = new AtomicLong();
        var processor = new SimpleProcessor(memory, new IOInstructionSet(() -> 10L, output::set));
        processor.process();

        assertThat(memory.peek(4)).isEqualTo(99);
    }

    @Test
    public void testWrite() {
        var memory = new ArrayMemory(3, 0, 99);

        var processor = new SimpleProcessor(memory, new IOInstructionSet(() -> 10L));
        processor.process();

        assertThat(memory.peek(0)).isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource("providesArgumentsForCompare")
    public void testCompare(long input, int output) {
        var memory = new ArrayMemory(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);

        var variable = new AtomicLong();
        var processor = new SimpleProcessor(memory, new IOInstructionSet(() -> input, variable::set));
        processor.process();

        assertThat(variable.get()).isEqualTo(output);
    }

    public static Stream<Arguments> providesArgumentsForCompare() {
        return Stream.of(
                Arguments.of(7, 999),
                Arguments.of(8, 1000),
                Arguments.of(9, 1001));
    }

}
