package com.dopscape.day9;

import com.dopscape.day5.IOInstructionSet;
import com.dopscape.intcode.memory.ArrayMemory;
import com.dopscape.intcode.memory.ListMemory;
import com.dopscape.intcode.processor.SimpleProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RelativeModeTest {

    @Test
    public void testRelativeMode() {
        var processor = new SimpleProcessor(new ArrayMemory(104,1125899906842624L,99), new IOInstructionSet(() -> 1L));
        processor.process();
    }

    @Test
    public void testQuine() {
        var out = new ArrayList<>();
        var memory = ListMemory.wrap(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99);
        var processor = new SimpleProcessor(memory, new IOInstructionSet(null, out::add));
        processor.process();
        assertThat(out).isEqualTo(List.of(109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L));
    }

    private static Stream<Arguments> createLongTests() {
        return Stream.of(
                Arguments.of(1219070632396864L, List.of(1102L, 34915192L, 34915192L, 7L, 4L, 7L, 99L, 0L)),
                Arguments.of(1125899906842624L, List.of(104L, 1125899906842624L, 99L))
        );
    }

    @ParameterizedTest
    @MethodSource("createLongTests")
    public void testLong(long expected, List<Long> program) {
        var out = new ArrayList<>();
        var processor = new SimpleProcessor(new ListMemory(new ArrayList<>(program)), new IOInstructionSet(null, out::add));
        processor.process();
        assertThat(out).isEqualTo(List.of(expected));
    }

}
