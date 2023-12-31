package day01

import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day01Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day01/part1_example.txt")
        assertEquals(142, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day01/input.txt")
        assertEquals(53_334, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day01/part2_example.txt")
        assertEquals(281, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day01/input.txt")
        assertEquals(52_834, part2(input))
    }
}
