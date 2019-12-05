package com.dopscape;

import com.dopscape.memory.ArrayMemory;
import com.dopscape.memory.Memory;
import com.dopscape.processor.Processor;
import com.dopscape.processor.instruction.instructionset.DefaultInstructionSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeExpansionTest {

    @ParameterizedTest
    @MethodSource("providesParameters")
    public void test(int[] input, int output) {
        Memory memory = new ArrayMemory(input);

        Processor processor = new Processor(memory, new DefaultInstructionSet(() -> 10, System.out));
        processor.process();

        assertThat(memory.get(4)).isEqualTo(output);
    }

    @Test
    public void test() {
        Memory memory = new ArrayMemory(3, 0, 99);

        Processor processor = new Processor(memory, new DefaultInstructionSet(() -> 10, System.out));
        processor.process();

        assertThat(memory.get(0)).isEqualTo(10);
    }

    public static Stream<Arguments> providesParameters() {
        return Stream.of(
                Arguments.of(new int[] {
                        1002,4,3,4,33
                }, 99)
        );
    }

}
