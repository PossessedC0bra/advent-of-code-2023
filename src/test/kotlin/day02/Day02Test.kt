package day02

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

internal class Day02Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day02/example.txt")
        assertEquals(8, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day02/input.txt")
        assertEquals(2_879, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day02/example.txt")
        assertEquals(2_286, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day02/input.txt")
        assertEquals(65_122, part2(input))
    }
}