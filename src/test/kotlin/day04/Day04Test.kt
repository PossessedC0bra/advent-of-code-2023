package day04

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class Day04Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day04/example.txt")
        assertEquals(13, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day04/input.txt")
        assertEquals(24_706, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day04/example.txt")
        assertEquals(30, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day04/input.txt")
        assertEquals(13_114_317, part2(input))
    }
}