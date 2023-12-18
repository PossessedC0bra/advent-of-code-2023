package day07

import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {

    @Test
    fun part1ExampleTest() {
        val input = readTestInput("day07/example.txt")
        assertEquals(6440, part1(input))
    }

    @Test
    fun part1Test() {
        val input = readTestInput("day07/input.txt")
        assertEquals(249_390_788, part1(input))
    }
}