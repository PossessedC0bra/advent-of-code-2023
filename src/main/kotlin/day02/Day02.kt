package day02

import readInput

fun main() {
    val input = readInput("day02/input.txt")

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

const val GAME_ID_GROUP_NAME = "gameId"
const val ROUNDS_GROUP_NAME = "rounds"
const val CUBE_COUNT_GROUP_NAME = "cubeCount"
const val CUBE_COLOR_GROUP_NAME = "cubeColor"

val GAME_REGEX = """Game\s+(?<${GAME_ID_GROUP_NAME}>\d+):\s+(?<${ROUNDS_GROUP_NAME}>.*)""".toRegex()
val CUBES_REGEX = """(?<${CUBE_COUNT_GROUP_NAME}>\d+)\s+(?<${CUBE_COLOR_GROUP_NAME}>\w+)""".toRegex()

fun parseLine(line: String): IndexedValue<Map<String, Int>> {
    val match = GAME_REGEX.find(line)!!

    val gameId = match.groups[GAME_ID_GROUP_NAME]!!.value.toInt()
    val cubes = CUBES_REGEX.findAll(match.groups[ROUNDS_GROUP_NAME]!!.value)
        .groupingBy { it.groups[CUBE_COLOR_GROUP_NAME]?.value!! }
        .aggregate { _, accumulator: Int?, element, _ ->
            maxOf(
                accumulator ?: 0,
                element.groups[CUBE_COUNT_GROUP_NAME]!!.value.toInt()
            )
        }

    return IndexedValue(gameId, cubes)
}

const val RED_THRESHOLD = 12
const val GREEN_THRESHOLD = 13
const val BLUE_THRESHOLD = 14

fun part1(input: List<String>) = input
    .map(::parseLine)
    .filter {
        it.value["red"]!! <= RED_THRESHOLD
                && it.value["green"]!! <= GREEN_THRESHOLD
                && it.value["blue"]!! <= BLUE_THRESHOLD
    }.sumOf { it.index }


fun part2(input: List<String>) = input
    .map(::parseLine)
    .sumOf { it.value["red"]!! * it.value["green"]!! * it.value["blue"]!! }