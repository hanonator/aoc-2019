package com.dopscape.day2;

import com.dopscape.intcode.memory.ArrayMemory;
import com.dopscape.intcode.Processor;
import com.dopscape.intcode.processor.SimpleProcessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeComputerTest {

    @Test
    public void testSimpleIntcodeComputer() {
        var memory = new ArrayMemory(1, 0, 0, 0, 99);
        var processor = new SimpleProcessor(memory, new SimpleInstructionSet());
        processor.process();

        assertThat(memory.peek(0)).isEqualTo(2);
    }

}
