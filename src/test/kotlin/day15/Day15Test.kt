package day15

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class Day15Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day15/example.txt")
        assertEquals(1_320, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day15/input.txt")
        assertEquals(509_784, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day15/example.txt")
        assertEquals(145, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day15/input.txt")
        assertEquals(230_197, part2(input))
    }
}