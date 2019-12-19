package com.dopscape.day11;

import com.dopscape.day5.IOInstructionSet;
import com.dopscape.intcode.memory.ListMemory;
import com.dopscape.intcode.processor.SimpleProcessor;
import com.dopscape.util.Input;

import java.io.IOException;
import java.net.URISyntaxException;

public class RobotApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var robot = new Robot();
        var memory = ListMemory.wrap(Input.readIntArray("day11-input"));
        var processor = new SimpleProcessor(memory, new IOInstructionSet(robot, robot));

        processor.process();
        System.out.println(robot.getPanelsPainted());
    }

}
