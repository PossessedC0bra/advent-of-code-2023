package day09

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class Day09Test {

    @Test
    fun testPart1Example() {
        val input = readTestInput("day09/example.txt")
        assertEquals(114, part1(input))
    }

    @Test
    fun testPart1() {
        val input = readTestInput("day09/input.txt")
        assertEquals(1_901_217_887, part1(input))
    }

    @Test
    fun testPart2Example() {
        val input = readTestInput("day09/example.txt")
        assertEquals(2, part2(input))
    }

    @Test
    fun testPart2() {
        val input = readTestInput("day09/input.txt")
        assertEquals(905, part2(input))
    }
}