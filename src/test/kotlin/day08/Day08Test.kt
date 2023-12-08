package day08

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class Day08Test {

    @Test
    fun part1Example1Test() {
        val input = readTestInput("day08/part1_example_1.txt")
        assertEquals(2, part1(input))
    }

    @Test
    fun part1Example2Test() {
        val input = readTestInput("day08/part1_example_2.txt")
        assertEquals(6, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day08/input.txt")
        assertEquals(19_631, part1(input))
    }

    @Test
    fun part2ExampleTest() {
        val input = readTestInput("day08/part2_example.txt")
        assertEquals(6, part2(input))
    }

    @Test
    fun part2Test() {
        val input = readTestInput("day08/input.txt")
        assertEquals(21_003_205_388_413, part2(input))
    }
}