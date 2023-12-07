package day03

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class Day03Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day03/part1.txt")
        assertEquals(4_361, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day03/input.txt")
        assertEquals(530_495, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day03/part1.txt")
        assertEquals(467_835, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day03/input.txt")
        assertEquals(80_253_814, part2(input))
    }
}