package day01

import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day01Test {

    @Test
    fun part1ExampleInputTest() {
        val input = readTestInput("day01/part1_example_input.txt")
        assertEquals(142, part1(input))
    }

    @Test
    fun part1InputTest() {
        val input = readTestInput("day01/input.txt")
        assertEquals(53334, part1(input))
    }

    @Test
    fun part2ExampleInputTest() {
        val input = readTestInput("day01/part2_example_input.txt")
        assertEquals(281, part2(input))
    }

    @Test
    fun part2InputTest() {
        val input = readTestInput("day01/input.txt")
        assertEquals(52834, part2(input))
    }
}
