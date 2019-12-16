package com.dopscape.day10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AsteroidTest {

    @Test
    public void testSimple() {
        assertThat(Map.of(List.of(
                ".#..#",
                ".....",
                "#####",
                "....#",
                "...##")).getClosestStation()).isEqualTo(Optional.of(new Station(3, 4, 8)));
    }

    @Test
    public void testMedium() {
        assertThat(Map.of(List.of(
                "......#.#.",
                "#..#.#....",
                "..#######.",
                ".#.#.###..",
                ".#..#.....",
                "..#....#.#",
                "#..#....#.",
                ".##.#..###",
                "##...#..#.",
                ".#....####"))
                .getClosestStation()).isEqualTo(Optional.of(new Station(5, 8, 33)));
    }

    @Test
    public void testBig() {
        assertThat(Map.of(List.of(
                ".#..##.###...#######",
                "##.############..##.",
                ".#.######.########.#",
                ".###.#######.####.#.",
                "#####.##.#.##.###.##",
                "..#####..#.#########",
                "####################",
                "#.####....###.#.#.##",
                "##.#################",
                "#####.##.###..####..",
                "..######..##.#######",
                "####.##.####...##..#",
                ".#####..#.######.###",
                "##...#.##########...",
                "#.##########.#######",
                ".####.#.###.###.#.##",
                "....##.##.###..#####",
                ".#.#.###########.###",
                "#.#.#.#####.####.###",
                "###.##.####.##.#..##")).getClosestStation()).isEqualTo(Optional.of(new Station(11, 13, 210)));
    }

}
