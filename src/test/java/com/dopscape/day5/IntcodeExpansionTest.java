package com.dopscape.day5;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.computer.memory.Memory;
import com.dopscape.computer.processor.Processor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeExpansionTest {

    @Test
    public void test() {
        Memory memory = new ArrayMemory(1002,4,3,4,33);

        AtomicInteger output = new AtomicInteger();
        Processor processor = new ExtendedIntcodeProcessor(memory, new ExtendedInstructionSet(() -> 10, output::set));
        processor.process();

        assertThat(memory.get(4)).isEqualTo(99);
    }

    @Test
    public void testWrite() {
        Memory memory = new ArrayMemory(3, 0, 99);

        AtomicInteger output = new AtomicInteger();
        Processor processor = new ExtendedIntcodeProcessor(memory, new ExtendedInstructionSet(() -> 10, output::set));
        processor.process();

        assertThat(memory.get(0)).isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource("providesArgumentsForCompare")
    public void testCompare(int input, int output) {
        Memory memory = new ArrayMemory(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);

        AtomicInteger variable = new AtomicInteger();
        Processor processor = new ExtendedIntcodeProcessor(memory, new ExtendedInstructionSet(() -> input, variable::set));
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
