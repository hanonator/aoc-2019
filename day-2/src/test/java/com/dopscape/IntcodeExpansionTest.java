package com.dopscape;

import com.dopscape.memory.ArrayMemory;
import com.dopscape.memory.Memory;
import com.dopscape.processor.Processor;
import com.dopscape.processor.instruction.instructionset.DefaultInstructionSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntcodeExpansionTest {

    @Test
    public void test() {
        Memory memory = new ArrayMemory(1002,4,3,4,33);

        Processor processor = new Processor(memory, new DefaultInstructionSet(() -> 10, System.out));
        processor.process();

        assertThat(memory.get(4)).isEqualTo(99);
    }

    @Test
    public void testWrite() {
        Memory memory = new ArrayMemory(3, 0, 99);

        Processor processor = new Processor(memory, new DefaultInstructionSet(() -> 10, System.out));
        processor.process();

        assertThat(memory.get(0)).isEqualTo(10);
    }

    @Test
    public void testCompare() {
        Memory memory = new ArrayMemory(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);

        Processor processor = new Processor(memory, new DefaultInstructionSet(() -> 8, System.out));
        processor.process();

        assertThat(memory.get(0)).isEqualTo(1000);
    }

}
