package com.dopscape.day7;

import com.dopscape.computer.memory.ArrayMemory;
import com.dopscape.day5.ExtendedIntcodeProcessor;
import com.dopscape.day7.part1.Thruster;
import com.dopscape.day7.part1.ThrusterInstructionSet;
import org.junit.jupiter.api.Test;

public class ThrusterTest {

    @Test
    public void test() {
        int[] program = {
                3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0
        };

        var sharedMemory = new ArrayMemory(program);
        var thrusters = new Thruster[5];

        for (int i = 0; i < 5; i++) {
            thrusters[i] = new Thruster(i == 0 ? new Thruster.NullThruster() : thrusters[i - 1], 4 - i);
            new ExtendedIntcodeProcessor(new ThrusterInstructionSet(thrusters[i])).process(sharedMemory);
        }
    }

}
