package com.dopscape.day6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

    @Test
    public void testTotalOrbits() throws URISyntaxException, IOException {
        Universe testUniverse = Universe.load(Paths.get(GraphTest.class.getClassLoader().getResource("day6-input-test").toURI()));

        assertThat(testUniverse.getTotalOrbits("COM")).isEqualTo(42);
    }

}
