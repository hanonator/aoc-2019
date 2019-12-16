package com.dopscape.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
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
                "...##"
        )).getStation()).isEqualTo(Optional.of(new Station(3, 4, 8)));
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
                ".#....####"
        )).getStation()).isEqualTo(Optional.of(new Station(5, 8, 33)));
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
                "###.##.####.##.#..##"
        )).getStation()).isEqualTo(Optional.of(new Station(11, 13, 210)));
    }

    @Test
    public void testVaporize() {
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
                "###.##.####.##.#..##"
        )).vaporize()).isEqualTo(Optional.of(new Asteroid(8, 2)));
    }

    @Test
    public void testPart1() throws URISyntaxException, IOException {
        assertThat(Map.of(List.of(
                ".#......##.#..#.......#####...#..",
                "...#.....##......###....#.##.....",
                "..#...#....#....#............###.",
                ".....#......#.##......#.#..###.#.",
                "#.#..........##.#.#...#.##.#.#.#.",
                "..#.##.#...#.......#..##.......##",
                "..#....#.....#..##.#..####.#.....",
                "#.............#..#.........#.#...",
                "........#.##..#..#..#.#.....#.#..",
                ".........#...#..##......###.....#",
                "##.#.###..#..#.#.....#.........#.",
                ".#.###.##..##......#####..#..##..",
                ".........#.......#.#......#......",
                "..#...#...#...#.#....###.#.......",
                "#..#.#....#...#.......#..#.#.##..",
                "#.....##...#.###..#..#......#..##",
                "...........#...#......#..#....#..",
                "#.#.#......#....#..#.....##....##",
                "..###...#.#.##..#...#.....#...#.#",
                ".......#..##.#..#.............##.",
                "..###........##.#................",
                "###.#..#...#......###.#........#.",
                ".......#....#.#.#..#..#....#..#..",
                ".#...#..#...#......#....#.#..#...",
                "#.#.........#.....#....#.#.#.....",
                ".#....#......##.##....#........#.",
                "....#..#..#...#..##.#.#......#.#.",
                "..###.##.#.....#....#.#......#...",
                "#.##...#............#..#.....#..#",
                ".#....##....##...#......#........",
                "...#...##...#.......#....##.#....",
                ".#....#.#...#.#...##....#..##.#.#",
                ".#.#....##.......#.....##.##.#.##"
        )).getStation()).isEqualTo(Optional.of(new Station(29, 28, 256)));
    }

    @Test
    public void testPart2() throws URISyntaxException, IOException {
        assertThat(Map.of(List.of(
                ".#......##.#..#.......#####...#..",
                "...#.....##......###....#.##.....",
                "..#...#....#....#............###.",
                ".....#......#.##......#.#..###.#.",
                "#.#..........##.#.#...#.##.#.#.#.",
                "..#.##.#...#.......#..##.......##",
                "..#....#.....#..##.#..####.#.....",
                "#.............#..#.........#.#...",
                "........#.##..#..#..#.#.....#.#..",
                ".........#...#..##......###.....#",
                "##.#.###..#..#.#.....#.........#.",
                ".#.###.##..##......#####..#..##..",
                ".........#.......#.#......#......",
                "..#...#...#...#.#....###.#.......",
                "#..#.#....#...#.......#..#.#.##..",
                "#.....##...#.###..#..#......#..##",
                "...........#...#......#..#....#..",
                "#.#.#......#....#..#.....##....##",
                "..###...#.#.##..#...#.....#...#.#",
                ".......#..##.#..#.............##.",
                "..###........##.#................",
                "###.#..#...#......###.#........#.",
                ".......#....#.#.#..#..#....#..#..",
                ".#...#..#...#......#....#.#..#...",
                "#.#.........#.....#....#.#.#.....",
                ".#....#......##.##....#........#.",
                "....#..#..#...#..##.#.#......#.#.",
                "..###.##.#.....#....#.#......#...",
                "#.##...#............#..#.....#..#",
                ".#....##....##...#......#........",
                "...#...##...#.......#....##.#....",
                ".#....#.#...#.#...##....#..##.#.#",
                ".#.#....##.......#.....##.##.#.##"
        )).vaporize()).isEqualTo(Optional.of(new Asteroid(17, 7)));
    }

}
