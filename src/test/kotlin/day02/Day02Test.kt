package day02

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

internal class Day02Test {

    @Test
    fun testPart1ExampleInput() {
        val input = readTestInput("day02/part1_example_input.txt")
        assertEquals(8, part1(input))
    }

    @Test
    fun testPart1RealInput() {
        val input = readTestInput("day02/input.txt")
        assertEquals(2879, part1(input))
    }

    @Test
    fun testPart2ExampleInput() {
        val input = readTestInput("day02/part2_example_input.txt")
        assertEquals(2286, part2(input))
    }

    @Test
    fun testPart2RealInput() {
        val input = readTestInput("day02/input.txt")
        assertEquals(65122, part2(input))
    }
}